package net.programmer.igoodie.history;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IndexSwap {

    private String label;
    private int fromIndex, toIndex;

    public IndexSwap(int fromIndex, int toIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public int getToIndex() {
        return toIndex;
    }

    public void perform(int[] array) {
        int temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
    }

    public void perform(Object[] array) {
        Object temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
    }

    public <T> void perform(List<T> list) {
        T temp = list.get(fromIndex);
        list.set(fromIndex, list.get(toIndex));
        list.set(toIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(fromIndex).append(" -> ").append(toIndex);
        if (label != null) builder.append(' ').append(label);
        return builder.toString();
    }

}
