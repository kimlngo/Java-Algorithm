package data.structure.impl;

import data.structure.api.ICustomLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSinglyLinkedListImplTest {

    @Test
    void testPushAndPop() {
        ICustomLinkedList<String> strLinkedList = new CustomSinglyLinkedListImpl<>();
        strLinkedList.push("Hello");
        strLinkedList.push("World");
        strLinkedList.push("Happy");

        assertEquals(3, strLinkedList.getLength());

        assertEquals("Happy", strLinkedList.pop());
        assertEquals("World", strLinkedList.pop());
        assertEquals("Hello", strLinkedList.pop());

        assertNull(strLinkedList.pop());
        assertEquals(0, strLinkedList.getLength());
    }
}