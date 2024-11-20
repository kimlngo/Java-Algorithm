package data.structure.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void testEnqueueAndDequeue() {
        Queue<String> sut = new Queue<>();
        sut.enqueue("FIRST");
        sut.enqueue("SECOND");
        sut.enqueue("THIRD");

        sut.print();

        assertEquals(3, sut.size);
        assertEquals("FIRST", sut.dequeue());
        assertEquals("SECOND", sut.dequeue());
        assertEquals("THIRD", sut.dequeue());

        assertNull(sut.dequeue());
        assertEquals(0, sut.size);

    }
}