package com.example.cnwlc.algorithm.hacker_rank.day22;

import java.util.Scanner;

public class Solution22 {

    public int getHeight(Node22 root) {
        //Write your code here
        int countLeft = 0;
        int countRight = 0;

        if(root.left != null) {
            countLeft = getHeight(root.left) +1;
        }

        if(root.right != null) {
            countRight = getHeight(root.right) +1;
        }

        return countLeft > countRight ? countLeft : countRight;
    }

    public Node22 insert(Node22 root, int data) {
        if (root == null) {
//            System.out.println("if data = "+data);
//            System.out.println("");
            return new Node22(data);
        } else {
            Node22 cur;
//            System.out.println("data = "+data+", root.data = "+root.data);
            if (data <= root.data) {
//                System.out.println("if root.left = "+root.left);
//                if(root.left != null)
//                    countLeft++;
                cur = insert(root.left, data);
//                System.out.println("cur = "+cur.toString());
                root.left = cur;
//                System.out.println("root.left = "+root.left);
            } else {
//                System.out.println("else root.right = "+root.right);
//                if(root.right != null)
//                    countRight++;
                cur = insert(root.right, data);
//                System.out.println("cur = "+cur.toString());
                root.right = cur;
//                System.out.println("root.right = "+root.right);
            }
//            System.out.println("");
            return root;
        }
    }

//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        Node22 root = null;
//
////        while (T-- > 0) {
////            int data = sc.nextInt();
////            root = insert(root, data);
////        }
//
//        int height = getHeight(root);
//        System.out.println(height);
//    }
}