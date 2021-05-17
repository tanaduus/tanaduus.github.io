package tanaduus.github.io.grammar;

import java.util.Iterator;

public class IterableHub implements Iterable<String>{



    @Override
    public Iterator<String> iterator() {
        return null;
    }

    public static void main(String[] args) {
        IterableHub hub = new IterableHub();
        for (String a: hub) {

        }
    }
}
