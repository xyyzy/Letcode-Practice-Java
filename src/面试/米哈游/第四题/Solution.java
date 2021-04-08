package 面试.米哈游.第四题;

import java.util.Scanner;

public class Solution {
    static class BinTreeNode {
        private char data;
        private BinTreeNode leftChild;
        private BinTreeNode rightChild;

        public BinTreeNode(char data) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public BinTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BinTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public BinTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BinTreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static BinTreeNode create(String gLists, int nodeQuntity) {
        BinTreeNode rootNode = null;
        BinTreeNode currNode = null;
        BinTreeNode[] stack = new BinTreeNode[nodeQuntity];
        int top = -1;
        int flag = 0;
        final int Left = 1, Right = 2;
        int index = 0;
        while (index < gLists.length()) {
            char c = gLists.charAt(index);
            switch (c) {
                case '(':
                    flag = Left;
                    stack[++top] = currNode;
                    break;
                case ',':
                    flag = Right;
                    break;
                case ')':
                    top--;
                    break;
                case ' ':
                    break;
                default:
                    currNode = new BinTreeNode(c);
                    if (rootNode == null) {
                        rootNode = currNode;
                    } else {
                        switch (flag) {
                            case Left:
                                stack[top].setLeftChild(currNode);
                                break;
                            case Right:
                                stack[top].setRightChild(currNode);
                                break;
                        }
                    }
            }
        }
        return rootNode;
    }

    public static void inOrder(BinTreeNode node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.println(node.data);
            inOrder(node.getRightChild());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        for (String s1 : s) {
            int num=0;
            BinTreeNode binTreeNode = create(s1, s1.length());
            inOrder(binTreeNode);
        }
    }
}
