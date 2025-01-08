package data.structure.impl;

import data.structure.api.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsertToBST() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(13);

        bst.insert(2);
        bst.insert(7);
        bst.insert(11);
        bst.insert(16);

        System.out.println(bst);
    }
}
