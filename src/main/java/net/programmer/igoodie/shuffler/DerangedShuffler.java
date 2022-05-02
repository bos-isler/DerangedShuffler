package net.programmer.igoodie.shuffler;

import net.programmer.igoodie.history.IndexSwap;
import net.programmer.igoodie.util.CollectionHelper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DerangedShuffler<T> extends FisherYatesShuffler<T> {

    int[] indexMap;
    boolean deranging;

    public DerangedShuffler(T[] array) {
        super(array);
        indexMap = new int[array.length];
        CollectionHelper.fill(indexMap, i -> i);
    }

    @Override
    public void shuffle() {
        super.shuffle();

        if (array.length == 0) {
            return;
        }

        deranging = true;

        List<Integer> nonChangedIndices = nonChangedIndices();

        while (nonChangedIndices.size() != 0) {
            if (nonChangedIndices.size() == 1) {
                int thisIndex = nonChangedIndices.get(0);
                int randomIndex;
                do {
                    randomIndex = this.random.nextInt(array.length);
                }
                while (randomIndex == thisIndex);
                pushSwap(thisIndex, randomIndex);
                return;
            }

            int nonChangedCount = nonChangedIndices.size();
            for (int i = 0; i < nonChangedCount - 1; i++) {
                int thisIndex = nonChangedIndices.get(i);
                int nextIndex = nonChangedIndices.get((i + 1) % nonChangedCount);
                pushSwap(thisIndex, nextIndex);
            }

            nonChangedIndices = nonChangedIndices();
        }

        deranging = false;
    }

    @Override
    protected void pushSwap(int fromIndex, int toIndex) {
        super.pushSwap(fromIndex, toIndex);
        IndexSwap swap = swapHistory.get(swapHistory.size() - 1);
        if (deranging) swap.setLabel("Deranging");
        swap.perform(indexMap);
    }

    private List<Integer> nonChangedIndices() {
        List<Integer> nonChanged = new LinkedList<>();

        for (int i = 0; i < indexMap.length; i++) {
            if (indexMap[i] == i) {
                nonChanged.add(i);
            }
        }

        return nonChanged;
    }

}
