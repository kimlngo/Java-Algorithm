package algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var two = new TreeNode(2);
        var three = new TreeNode(3);
        var five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.right = five;

        System.out.println(binaryTreePaths(root));
    }

    private static List<String> binaryTreePaths(TreeNode node) {
        List<String> results = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        path.add(node);

        traverse(node, path, results);
        return results;
    }

    private static void traverse(TreeNode node, List<TreeNode> path, List<String> results) {
        if (node.left == null && node.right == null) {
            //found the leaf node, print all the paths + this node
            results.add(path.stream()
                            .map(n -> String.valueOf(n.val))
                            .collect(Collectors.joining("->")));
            return;
        }

        if (node.left != null) {
            path.add(node.left);
            traverse(node.left, path, results);
            path.remove(node.left);
        }

        if (node.right != null) {
            path.add(node.right);
            traverse(node.right, path, results);
            path.remove(node.right);
        }
    }
}
