package com.vc.medium;

import com.vc.hard.TreeNode;

class L865 {
    static class Entry {
        TreeNode node;
        int depth;

        Entry(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Entry entry = solve(root, 0);
        return entry.node;
    }

    private Entry solve(TreeNode root, int depth) {
        if(root == null) return new Entry(null, depth);

        Entry left = solve(root.left, depth + 1);
        Entry right = solve(root.right, depth + 1);

        if(left.depth > right.depth) return left;
        else if(left.depth < right.depth) return right;
        else return new Entry(root, left.depth);
    }
}
