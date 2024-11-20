package data.structure.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue sut;

    @BeforeEach
    void setupQueue() {
        sut = new Queue<String>();
    }

    @Test
    void testEnqueueAndDequeue() {
        sut.enqueue("FIRST");
        sut.enqueue("SECOND");
        sut.enqueue("THIRD");

        assertEquals(3, sut.size);
        assertEquals("FIRST", sut.dequeue());
        assertEquals("SECOND", sut.dequeue());
        assertEquals("THIRD", sut.dequeue());

        assertNull(sut.dequeue());
        assertEquals(0, sut.size);
    }
}