package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class LinkedListTest {

    @Test
    void tests() {

        //Initialize
        LinkedList<testClass> list = new LinkedList<>();
        Predicate<testClass> predicate = (element)->element.value > 0;
        Function<testClass, String> function = element->String.valueOf(element.value);
        Consumer<testClass> consumer = element->element.value--;

        //Fill lists
        list.add(new testClass(5));
        list.add(new testClass(9));
        list.add(new testClass(2));
        list.add(new testClass(-5));
        list.add(new testClass(1));
        list.add(new testClass(-16));

        //Check
        Assertions.assertFalse(list.all(predicate));
        Assertions.assertTrue(list.any(predicate));
        Assertions.assertEquals(5, list.first(predicate).value);
        Assertions.assertEquals(1, list.last(predicate).value);
        Assertions.assertEquals(4, list.count(predicate));
        Assertions.assertNull(list.single(predicate));

        LinkedList<testClass> filteredList = (LinkedList<testClass>) ((ILinkedList<testClass>) list).filter(predicate);
        for (testClass element : filteredList) {
            Assertions.assertTrue(0 < element.value);
        }

        list.removeFirst();
        list.removeFirst();
        list.remove(2);

        Assertions.assertEquals(2, list.single(predicate).value);

        LinkedList<String> stringList = (LinkedList<String>) ((ILinkedList<testClass>) list).select(function);
        Assertions.assertEquals("2", stringList.find(0));
        Assertions.assertEquals("-5", stringList.find(1));
        Assertions.assertEquals("-16", stringList.find(2));

        LinkedList<testClass> consumedList = (LinkedList<testClass>) ((ILinkedList<testClass>) list).map(consumer);
        Assertions.assertEquals(1, consumedList.find(0).value);
        Assertions.assertEquals(-6, consumedList.find(1).value);
        Assertions.assertEquals(-17, consumedList.find(2).value);
    }

    private class testClass {

        int value;

        testClass(int value) {
            this.value = value;

        }
    }

}