package data.structure.impl;

import data.structure.api.tree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setupBST() {
        bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(13);

        bst.insert(2);
        bst.insert(7);
        bst.insert(11);
        bst.insert(16);
    }

    @Test
    public void testInsertToBST() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(13);

        bst.insert(2);
        bst.insert(7);
        bst.insert(11);
        bst.insert(16);

        System.out.println(bst);

        //Assert true
        Assertions.assertTrue(bst.contains(10));
        Assertions.assertTrue(bst.contains(5));
        Assertions.assertTrue(bst.contains(7));
        Assertions.assertTrue(bst.contains(11));
        Assertions.assertTrue(bst.contains(13));

        //Assert false
        Assertions.assertFalse(bst.contains(6));
        Assertions.assertFalse(bst.contains(3));
        Assertions.assertFalse(bst.contains(8));
        Assertions.assertFalse(bst.contains(12));
        Assertions.assertFalse(bst.contains(17));

        //Assert Find
        var node = bst.find(10);
        Assertions.assertEquals(10, node.getValue());

        node = bst.find(7);
        Assertions.assertEquals(7, node.getValue());

        Assertions.assertNull(bst.find(15));
    }

    @Test
    public void testBreathFirstSearch() {
        Assertions.assertEquals("[10, 5, 13, 2, 7, 11, 16]", bst.breathFirstSearch());
    }

    @Test
    public void testDepthFirstSearch_PreOrder() {
        Assertions.assertEquals("[10, 5, 2, 7, 13, 11, 16]", bst.depthFirstSearch_PreOrder());
    }

    @Test
    public void testDepthFirstSearch_PostOrder() {
        Assertions.assertEquals("[2, 7, 5, 11, 16, 13, 10]", bst.depthFirstSearch_PostOrder());
    }

    @Test
    public void testDepthFirstSearch_InOrder() {
        Assertions.assertEquals("[2, 5, 7, 10, 11, 13, 16]", bst.depthFirstSearch_InOrder());
    }
}
