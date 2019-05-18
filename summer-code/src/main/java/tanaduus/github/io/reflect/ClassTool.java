package tanaduus.github.io.reflect;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 通过包名获取class
 *
 * @author zhanbai
 */
public class ClassTool {

    private static final String CLASS_FILE_PROTOCOL = "file";
    private static final String JAR_FILE_PROTOCOL = "jar";
    private static final String UTF8_ENCODE = "UTF-8";

    /**
     * 从包package中获取所有的Class
     *
     * @param packageName 包
     * @return Set Class
     */
    public static Set<Class<?>> getClasses(String packageName) throws Exception {
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        // 包文件夹名字
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            dirs = contextClassLoader.getResources(packageDirName);
            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if (CLASS_FILE_PROTOCOL.equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), UTF8_ENCODE);
                    addClassesInPackageByFile(packageName, filePath, classes);
                    continue;
                }


                if (JAR_FILE_PROTOCOL.equals(protocol)) {
                    // getJarFile
                    JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
                    addClassFromJarFile(packageName, classes, packageDirName, jar);
                } else {
                    // 其他类型不处理 日志？
                }
            }
        } catch (Throwable e) {
            throw new Exception("getClasses occurs error message:" + e.getMessage(), e);
        }

        return classes;
    }

    private static void addClassFromJarFile(String packageName, Set<Class<?>> classes, String packageDirName, JarFile jar) throws IOException, ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        // 从此jar包 得到一个枚举类
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            // 去除开头的/
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }

            // 包名不相同
            if (!name.startsWith(packageDirName)) {
                continue;
            }

            int idx = name.lastIndexOf('/');
            String packageNameVal = packageName;

            String fileName;
            if (idx != -1) {
                // 获取包名 把"/"替换成"."
                packageNameVal = name.substring(0, idx).replace('/', '.');
                fileName = name.substring(packageNameVal.length() + 1);
            } else {
                fileName = name;
            }

            // 如果是一个.class文件 而且不是目录
            if (fileName.endsWith(".class") && !entry.isDirectory()) {
                // 去掉后面的".class" 获取真正的类名
                String classSimpleName = fileName.substring(0, fileName.length() - 6);
                // loadClass 方法 不会初始化class
                classes.add(contextClassLoader.loadClass(packageNameVal + '.' + classSimpleName));
            }
        }
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName 包名
     * @param packagePath 包路径
     * @param classes     包存储集合
     */
    private static void addClassesInPackageByFile(
            String packageName,
            String packagePath,
            Set<Class<?>> classes) throws ClassNotFoundException {
        if (null == packagePath) {
            return;
        }

        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] dirfiles = dir.listFiles(new FileFilter() {

            // 过滤
            @Override
            public boolean accept(File file) {
                return (file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        if (null == dirfiles) {
            return;
        }

        for (File file : dirfiles) {
            if (file.isDirectory()) {
                addClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String classSimpleName = file.getName().substring(0, file.getName().length() - 6);
                // loadClass 方法 不会初始化class
                classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + classSimpleName));
            }
        }
    }
}