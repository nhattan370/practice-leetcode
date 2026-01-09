package com.rikkei;

public class a865_SmallestSubtreeWithAllDeepestNode {
    private class Result{
        int depth;
        TreeNode node;

        public Result(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findDeepestNode(root).node;
    }
    private Result findDeepestNode(TreeNode node){
        if(node==null) return new Result(0, null);

        Result left = findDeepestNode(node.left);
        Result right = findDeepestNode(node.right);

        if(left.depth==right.depth){
            return new Result(right.depth+1, node);
        }else if(left.depth > right.depth){
            return new Result(left.depth+1, left.node);
        }else{
            return new Result(right.depth+1, right.node);
        }
    }
}
