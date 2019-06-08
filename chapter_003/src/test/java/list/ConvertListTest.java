package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void when2and3ThenList5() {
        ConvertList list = new ConvertList();
        List<int[]> newlist = new ArrayList<int[]>();
        int[] input1 = {1, 2};
        int[] input2 = {3, 4, 5};
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5
        );

        newlist.add(input1);
        newlist.add(input2);

        List<Integer> result = list.convert(newlist);
        assertThat(result, is(expect));
    }
}
