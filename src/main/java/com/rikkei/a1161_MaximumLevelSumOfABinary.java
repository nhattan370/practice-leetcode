package com.rikkei;

import java.util.LinkedList;
import java.util.Queue;

public class a1161_MaximumLevelSumOfABinary {
    public static class TreeNode {
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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int resultLevel = 0, resultSum = Integer.MIN_VALUE, currentLevel=0;

        if(root!=null) queue.add(root);

        while(!queue.isEmpty()){
            currentLevel++;
            int size = queue.size();
            int time = 0;
            int currentSum = 0;
            while(time<size){
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.val;
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                time++;
            }
            if(currentSum>resultSum){
                resultSum=currentSum;
                resultLevel=currentLevel;
            }
        }
        return resultLevel;
    }
}
