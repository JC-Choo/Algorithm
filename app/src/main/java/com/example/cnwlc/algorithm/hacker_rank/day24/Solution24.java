package com.example.cnwlc.algorithm.hacker_rank.day24;

import java.util.LinkedList;

public class Solution24 {
    public Node24 removeDuplicates(Node24 head) {
        //Write your code here
        if (head == null) {
            return null;
        }

        LinkedList<Integer> set = new LinkedList<>();
        Node24 preNode = head;
        Node24 nextNode = preNode.next;

        if (nextNode == null) return head;
        set.add(preNode.data);

        while (nextNode != null) {
            if(set.contains(nextNode.data)) {
                preNode.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                set.add(nextNode.data);
                preNode = nextNode;
                nextNode = nextNode.next;
            }
        }

        return head;
    }

    public Node24 insert(Node24 head, int data) {
        Node24 p = new Node24(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node24 start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public void display(Node24 head) {
        Node24 start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
}
