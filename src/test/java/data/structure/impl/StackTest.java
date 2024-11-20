package data.structure.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop() {
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
}