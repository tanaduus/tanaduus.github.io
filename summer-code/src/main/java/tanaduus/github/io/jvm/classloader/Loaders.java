package tanaduus.github.io.jvm.classloader;

import java.net.URL;

public class Loaders {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("java.ext.dirs"));

        String property = System.getProperty("java.class.path");
        String[] props = property.split(":");
        for(String prop : props){
            System.out.println(prop);
        }

    }
}
