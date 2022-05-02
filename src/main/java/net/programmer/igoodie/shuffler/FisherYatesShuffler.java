package net.programmer.igoodie.shuffler;

public class FisherYatesShuffler<T> extends Shuffler<T> {

    public FisherYatesShuffler(T[] array) {
        super(array);
    }

    @Override
    public void shuffle() {
        for (int i = array.length - 1; i >= 1; i--) {
            int targetIndex = this.random.nextInt(i + 1);
            pushSwap(i, targetIndex);
        }
    }

}
