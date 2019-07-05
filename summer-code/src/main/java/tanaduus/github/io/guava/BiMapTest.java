package tanaduus.github.io.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {

    public static void main(String[] args) {

        BiMap<Integer, String> biMap = HashBiMap.create();

        biMap.put(1,"a");
        biMap.put(2,"b");

        biMap.forEach((k,v)-> System.out.println(k+v));

        BiMap<String, Integer> newBiMap = biMap.inverse();

        newBiMap.forEach((k,v)-> System.out.println(k+v));

        biMap.put(3,"c");

        newBiMap.forEach((k,v)-> System.out.println(k+v));
    }
}
