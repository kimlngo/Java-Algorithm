package data.structure.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop_WithString() {
        Stack<String> stack = new Stack<>();

        stack.push("FIRST");
        stack.push("SECOND");
        stack.push("THIRD");

        stack.print();

        assertEquals(3, stack.size);
        assertEquals("THIRD", stack.pop());
        assertEquals("SECOND", stack.pop());
        assertEquals("FIRST", stack.pop());

        assertNull(stack.pop());
        assertEquals(0, stack.size);
    }

    @Test
    void testPushAndPop_WithInteger() {
        Stack<Integer> intStack = new Stack<>();

        intStack.push(Integer.valueOf(23));
        intStack.push(Integer.valueOf(56));
        intStack.push(Integer.valueOf(79));
        intStack.push(Integer.valueOf(85));

        intStack.print();

        assertEquals(4, intStack.size);
        assertEquals(85, intStack.pop());
        assertEquals(79, intStack.pop());
        assertEquals(56, intStack.pop());
        assertEquals(23, intStack.pop());

        assertNull(intStack.pop());
        assertEquals(0, intStack.size);
    }
}