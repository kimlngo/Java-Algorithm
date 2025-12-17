package algo.tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);

        root.right = two;
        two.left = three;

        System.out.println(postOrderTraversal(root));
    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(root.val);

        List<Integer> result = new ArrayList<>();
        postTraverse(root, result);
        return result;
    }

    private static void postTraverse(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postTraverse(node.left, result);
        postTraverse(node.right, result);
        result.add(node.val);
    }
}
