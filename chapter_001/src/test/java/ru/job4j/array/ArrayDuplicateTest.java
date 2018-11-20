package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input =  {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Супер", "Мир"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    @Test
    public void whenRemoveAllDuplicatesThenArrayWithoutDuplicate() {
        String[] input =  {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] expect = {"Привет"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}