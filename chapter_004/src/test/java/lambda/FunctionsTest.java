package lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diaposon(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diaposon(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionLogResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diaposon(1, 4, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D, 1.0986122886681098D);
        assertThat(result, is(expected));
    }
}
