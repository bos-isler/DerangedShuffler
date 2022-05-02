package net.programmer.igoodie.shuffler;

import net.programmer.igoodie.history.IndexSwap;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Shuffler<T> {

    protected T[] array;
    protected Random random;
    protected List<IndexSwap> swapHistory;

    Shuffler(T[] array) {
        this.array = array;
        this.random = new Random();
        this.swapHistory = new LinkedList<>();
    }

    public List<IndexSwap> getSwapHistory() {
        return swapHistory;
    }

    public abstract void shuffle();

    protected void pushSwap(int fromIndex, int toIndex) {
        IndexSwap swap = new IndexSwap(fromIndex, toIndex);
        swap.perform(this.array);
        swapHistory.add(swap);
    }

    public <K> void applyHistory(K[] array) {
        for (IndexSwap indexSwap : swapHistory) {
            indexSwap.perform(array);
        }
    }

}
