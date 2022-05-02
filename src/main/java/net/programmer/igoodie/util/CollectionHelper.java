package net.programmer.igoodie.util;

import java.util.function.Function;

public class CollectionHelper {

    public static void fill(int[] array, Function<Integer, Integer> generateByIndex) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generateByIndex.apply(i);
        }
    }

    public static <T> void fill(T[] array, Function<Integer, T> generateByIndex) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generateByIndex.apply(i);
        }
    }

}
