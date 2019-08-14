package tanaduus.github.io.jvm.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {

    public static void main(String[] args) {
        SoftReference softReference = new SoftReference(new Object());
        WeakReference weakReference = new WeakReference(new Object());

        while(true){

        }
    }
}
