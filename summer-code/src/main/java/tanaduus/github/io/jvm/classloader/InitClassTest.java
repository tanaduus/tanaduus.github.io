package tanaduus.github.io.jvm.classloader;

public class InitClassTest {

    public static void main(String[] args) {
        //System.out.println(child.value);

        //father[] f = new father[10];

        System.out.println(constString.HELLO);
    }
}

class father {
    static {
        System.out.println("father");
    }

    static int value = 13;
}

class child extends father {
    static {
        System.out.println("child");
    }
}

class constString {
    static {
        System.out.println("constString");
    }

    public static final String HELLO = "hello";
}