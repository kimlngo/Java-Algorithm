package algo.tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);

        root.right = two;
        two.left = three;

        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return List.of(root.val);

        List<Integer> result = new ArrayList<>();
        preTraverse(root, result);
        return result;
    }

    private static void preTraverse(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        result.add(node.val);
        preTraverse(node.left, result);
        preTraverse(node.right, result);
    }
}
