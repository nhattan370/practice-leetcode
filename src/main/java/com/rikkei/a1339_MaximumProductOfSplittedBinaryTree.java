package com.rikkei;

import java.util.LinkedList;
import java.util.Queue;

public class a1339_MaximumProductOfSplittedBinaryTree {
    long maxProduct = 0;
    long totalSum = 0;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxProduct(TreeNode root) {
        totalSum = sumAllTree(root);
        subTreeSum(root);
        return (int)(maxProduct%1_000_000_007);
    }

    private long subTreeSum(TreeNode node){
        if(node==null) return 0;
        long left = subTreeSum(node.left);
        long right = subTreeSum(node.right);

        long ansSum = node.val + left + right;
        maxProduct = Math.max((totalSum-ansSum)*ansSum, maxProduct);
        return ansSum;
    }

    private long sumAllTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        long result=0;
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result += node.val;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return result;
    }
}
