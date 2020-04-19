package io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = Config.class.getClassLoader().getResource("test.properties").getFile();
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("status"),
                is("junior")
        );
    }
}
