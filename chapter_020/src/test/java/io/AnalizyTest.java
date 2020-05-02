package io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {
    @Test
    public void whenServerBreakThenLog() {
        String path = Config.class.getClassLoader().getResource("server.log").getFile();
        Analizy analizy = new Analizy();
        analizy.run(path, "target.log");
        assertThat(analizy.value("12:17:11"), is("12:20:09"));
    }
}
