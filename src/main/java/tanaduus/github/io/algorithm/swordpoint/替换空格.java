package tanaduus.github.io.algorithm.swordpoint;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    /**
     * 创建内存法--不推荐
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(chars[i]);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 其实StringBuffer使用数组实现的。只要实现数组的插入方法即可。
     * 需要注意的是如何进行元素的移动。由于空格占一个空间，"%20"占三个空间。意味着空格后的元素，都需要往后移动三个位置。
     * 那么可以通过计算需要移动的总次数，来决定从头开始还是从尾开始。
     */
    public String replaceSpace2(StringBuffer str) {

        return "";
    }
}
