package com.github.contest.binaryTree;

import java.util.LinkedList;


/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */

public class FindCorrespondingNode {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(cloned);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.getVal() == target.getVal()) {
                    return node;
                }

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }

        return null;
    }

}
