package daily;

import helpers.TreeNode;

public class UnivalTree {
    private class Result {
        int count;
        boolean isUnival;
    }

    public int count(TreeNode root) {
        return countResult(root).count;
    }

    private Result countResult(TreeNode current) {
        // Handles empty node.
        Result result = new Result();
        if (current == null) {
            result.count = 0;
            result.isUnival = true;
            return result;
        }

        // Recursive call on left & right sub-trees.
        Result leftResult = countResult(current.left);
        Result rightResult = countResult(current.right);

        // Constructs the result.
        result.isUnival = (current.left == null && current.right == null)
                || (current.left != null && current.left.val == current.val && leftResult.isUnival
                && current.right != null && current.right.val == current.val && rightResult.isUnival);
        result.count = leftResult.count + rightResult.count + (result.isUnival ? 1 : 0);
        return result;
    }
}
