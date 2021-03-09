package 最热100题._105_从前序与中序遍历序列构造二叉树;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 | inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                //前序数组分割 Arrays.copyOfRange区间是[,)
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                //中序数组分割
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;
    }

        HashMap<Integer,Integer> map;
        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;
            map= new HashMap<>();
            if (preLen != inLen) {
                throw new RuntimeException("Incorrect input data.");
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }

            return helper(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
        }


        private TreeNode helper(int[] preorder, int preLeft, int preRight,
                                   int[] inorder, int inLeft, int inRight) {
            // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            int pivot = preorder[preLeft];
            TreeNode root = new TreeNode(pivot);
            int pivotIndex;
            pivotIndex = map.get(pivot);
            root.left = helper(preorder,preLeft+1,preLeft+pivotIndex-inLeft,
                    inorder,inLeft,pivotIndex-1);
            root.right = helper(preorder,preLeft+pivotIndex-inLeft+1,preRight,inorder,pivotIndex+1,inRight);
            return root;
        }

}
