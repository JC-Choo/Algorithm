package com.example.cnwlc.algorithm.hacker_rank;

import com.example.cnwlc.algorithm.hacker_rank.day12.Student;
import com.example.cnwlc.algorithm.hacker_rank.day13.Book;
import com.example.cnwlc.algorithm.hacker_rank.day13.MyBook;
import com.example.cnwlc.algorithm.hacker_rank.day15.Node;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class HackerRankJava {

    // region day 16
    @Test
    public void day16_exceptionsStringToInteger() {
        Scanner in = new Scanner(System.in);
//        String S = in.next();
        String S = "3124";

        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }

//        System.out.println(Optional.of(in.hasNextInt()).filter(b -> b).map(b -> "" + in.nextInt()).orElse("Bad String"));
//        System.out.println(Optional.of(in.hasNextInt()).filter(b -> b).map(b -> "" + in.nextInt()).orElseGet(() -> "Bad String"));
    }
    // endregion

    // region day 15
    // TODO : 어렵당
    @Test
    public void day15_linkedList() {
//        Scanner sc = new Scanner(System.in);
        Node head = null;
//        int N = sc.nextInt();

        int N = 4;

        while (N-- > 0) {
//            int ele = sc.nextInt();
//            head = insert(head, ele);
            head = insert(head, N);
        }
        display(head);
//        sc.close();
    }

    // 고정
    private void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.println(start.data + " ");
            start = start.next;
        }
    }

    private Node insert(Node head, int data) {
        // Complete this method
        System.out.println("head = " + head + ", data = " + data);

        if (head == null) {
            return new Node(data);
        } else if (head.next == null) {
            head.next = new Node(data);
        } else {
            insert(head.next, data);
        }

        return head;
    }
    // endregion

    class Difference {
        private int[] elements;
        public int maximumDifference;

        Difference(int[] a) {
            this.elements = a;
        }

        public void computeDifference() {
            Arrays.sort(elements);
            maximumDifference = Math.abs(elements[elements.length - 1] - elements[0]);
            System.out.println(maximumDifference);
        }
    }

    @Test
    public void day14_scope() {
        Difference d = new Difference(new int[]{1, 3, 5});
        d.computeDifference();
    }

    @Test
    public void day13_abstractClasses() {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }

    @Test
    public void day12_inheritance() {
//        Scanner scan = new Scanner(System.in);
//        String firstName = scan.next();
//        String lastName = scan.next();
//        int id = scan.nextInt();
//        int numScores = scan.nextInt();
//        int[] testScores = new int[numScores];
//        for(int i = 0; i < numScores; i++){
//            testScores[i] = scan.nextInt();
//        }
//        scan.close();


        String firstName = "Heraldo";
        String lastName = "Memelli";
        int id = 8135627;
        int[] testScores = {100, 80};


        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }

    @Test
    public void day4_class_vs_instance() {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = 4;
        for (int i = 0; i < T; i++) {
//            int age = sc.nextInt();
            Person p;
            if (i == 0) {
                p = new Person(-1);
            } else if (i == 1) {
                p = new Person(10);
            } else if (i == 2) {
                p = new Person(16);
            } else {
                p = new Person(18);
            }
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
//        sc.close();
    }

    @Test
    public void day1_data_type() {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int x_int;
        double x_double;
        String x_string;

        x_int = scan.nextInt();
        System.out.println(i + x_int);

        x_double = scan.nextDouble();
        System.out.println(d + x_double);

        scan.nextLine();
        x_string = scan.nextLine();
        System.out.println(s + x_string);

        scan.close();
    }
}
