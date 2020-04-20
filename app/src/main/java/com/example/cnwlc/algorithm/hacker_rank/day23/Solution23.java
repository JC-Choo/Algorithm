package com.example.cnwlc.algorithm.hacker_rank.day23;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution23 {
    public void levelOrder(Node23 root) {
        //Write your code here
        LinkedList<Node23> list = new LinkedList();
        list.add(root);

        while (!list.isEmpty()) {
            Node23 a = list.remove();
            System.out.println("a.data = "+a.data+"\na.left = "+a.left+"\na.right = "+a.right);
//            System.out.print(a.data+" ");
            if(a.left != null) {
                list.add(a.left);
                System.out.println("left = "+a.data+", "+a.left+", "+a.right);
            }
            if(a.right != null) {
                list.add(a.right);
                System.out.println("right = "+a.data+", "+a.left+", "+a.right);
            }
            System.out.println();
        }
    }

    public Node23 insert(Node23 root, int data) {
        if (root == null) {
            return new Node23(data);
        } else {
            Node23 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        Node23 root = null;
//
//        while (T-- > 0) {
//            int data = sc.nextInt();
//            root = insert(root, data);
//        }
//
//        levelOrder(root);
//    }
}
