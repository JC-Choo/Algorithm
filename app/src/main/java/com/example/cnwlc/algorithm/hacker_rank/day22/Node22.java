package com.example.cnwlc.algorithm.hacker_rank.day22;

public class Node22 {
    Node22 left, right;
    int data;

    Node22(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node22{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }

}
