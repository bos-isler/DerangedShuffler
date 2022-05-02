import net.programmer.igoodie.shuffler.FisherYatesShuffler;
import net.programmer.igoodie.shuffler.DerangedShuffler;
import net.programmer.igoodie.util.CollectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShufflerTests {

    @Test
    public void shouldApplyHistory() {
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] array2 = {1, 2, 3, 4, 5, 6, 7};

        FisherYatesShuffler<Integer> shuffler = new FisherYatesShuffler<>(array1);
        shuffler.shuffle();

        shuffler.applyHistory(array2);

        System.out.println(Arrays.asList(array1));
        System.out.println(Arrays.asList(array2));
        Assertions.assertArrayEquals(array1, array2);
    }

    @Test
    public void shouldDerange() {
        Integer[] array = new Integer[((int) (Math.random() * 100))];
        CollectionHelper.fill(array, i -> i + 1);

        DerangedShuffler<Integer> shuffler = new DerangedShuffler<>(array);

        shuffler.shuffle();

        shuffler.getSwapHistory().forEach(System.out::println);

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            Assertions.assertNotEquals(array[i], i + 1);
        }
    }

}
