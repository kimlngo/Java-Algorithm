package algo.tree;

import java.util.*;

public class TreeRevision {
    public static void main(String[] args) {
        var root = new TreeNode(4);
        var two = new TreeNode(2);
        var seven = new TreeNode(7);

        var one = new TreeNode(1);
        var three = new TreeNode(3);
        var six = new TreeNode(6);

        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;

        System.out.println(traverseBFS(root));
        System.out.println(traverseBFSByLevel(root));
    }

    private static List<TreeNode> traverseBFS(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) return List.of(root);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<TreeNode> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result;
    }

    private static List<List<TreeNode>> traverseBFSByLevel(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) return List.of(List.of(root));

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<TreeNode>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                level.add(node);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
        }

        return result;
    }
}
