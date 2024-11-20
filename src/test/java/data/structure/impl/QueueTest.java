package data.structure.impl;

import data.structure.api.IQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void testEnqueueAndDequeue_WithString() {
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

    @Test
    void testEnqueueAndDequeue_WithInteger() {
        Queue<Integer> intQueue = new Queue<>();

        intQueue.enqueue(Integer.valueOf(23));
        intQueue.enqueue(Integer.valueOf(56));
        intQueue.enqueue(Integer.valueOf(79));
        intQueue.enqueue(Integer.valueOf(85));

        intQueue.print();

        assertEquals(4, intQueue.size);
        assertEquals(23, intQueue.dequeue());
        assertEquals(56, intQueue.dequeue());
        assertEquals(79, intQueue.dequeue());
        assertEquals(85, intQueue.dequeue());

        assertNull(intQueue.dequeue());
        assertEquals(0, intQueue.size);
    }
}