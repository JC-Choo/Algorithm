package com.example.cnwlc.algorithm.hacker_rank;

import com.example.cnwlc.algorithm.hacker_rank.day12.Student;
import com.example.cnwlc.algorithm.hacker_rank.day13.Book;
import com.example.cnwlc.algorithm.hacker_rank.day13.MyBook;
import com.example.cnwlc.algorithm.hacker_rank.day15.Node;
import com.example.cnwlc.algorithm.hacker_rank.day22.Node22;
import com.example.cnwlc.algorithm.hacker_rank.day22.Solution22;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class HackerRankJava {

    // region day 22
    // TODO : 재귀에 대해 생각좀 해보자
    @Test
    public void day22_binarySearchTrees() {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        Node22 root = null;

//        while (T-- > 0) {
//            int data = sc.nextInt();
//           root = insert(root, data);
//        }

        Solution22 solu = new Solution22();
        int data = 3;
        root = solu.insert(root, data);  // root = null
        // insert : root == null -> root = Node22(3) => root.data = 3
        data = 5;
        root = solu.insert(root, data);  // root = Node22(3)
        // insert : root != null -> data(=5) > root.data(3) -> else -> insert(root.right(=null), 5) -> root == null -> return new Node22(5) -> root.right = Node22(5) ->
        data = 2;   // root = Node22(5)
        root = solu.insert(root, data);
        data = 1;
        root = solu.insert(root, data);
        data = 4;
        root = solu.insert(root, data);
        data = 6;
        root = solu.insert(root, data);
        data = 7;
        root = solu.insert(root, data);

        int height = solu.getHeight(root);
        System.out.println(height);
//        System.out.println(solu.getHeight(root));
    }
    // endregion

    // region day 21
    public class Generics {
        public void main(String args[]) {
//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
            int n = 10;
            Integer[] intArray = new Integer[n];
            for (int i = 0; i < n; i++) {
//                intArray[i] = scanner.nextInt();
                intArray[i] = (int) (Math.random() * 10);
            }

//            n = scanner.nextInt();
            n = 5;
            String[] stringArray = new String[n];
            for (int i = 0; i < n; i++) {
//                stringArray[i] = scanner.next();
                stringArray[i] = "Hello_" + i;
            }

            Printer<Integer> intPrinter = new Printer<>();
            Printer<String> stringPrinter = new Printer<>();
            intPrinter.printArray(intArray);
            stringPrinter.printArray(stringArray);
            if (Printer.class.getDeclaredMethods().length > 1) {
                System.out.println("The Printer class should only have 1 method named printArray.");
            }
        }
    }

    class Printer<T> {

        public void printArray(T[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

    }

    @Test
    public void day21_generics() {

    }
    // endregion

    // region day 19
    interface AdvancedArithmetic {
        int divisorSum(int n);
    }

    // 작성
    class Calculator_day19 implements AdvancedArithmetic {
        public int divisorSum(int n) {
            int result = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    result += i;
                }
            }

            return result;
        }
    }

    @Test
    public void day19_interfaces() {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        scan.close();
//
        AdvancedArithmetic myCalculator = new Calculator_day19();
        int sum = myCalculator.divisorSum(6);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
    // endregion

    // region day 18
    class Solution_day18 {
        private LinkedList<Character> stack = new LinkedList<>();
        private LinkedList<Character> queue = new LinkedList<>();
//        Stack<Character> stack = new Stack<>();
//        Queue<Character> queue = new LinkedList<>();

        private void pushCharacter(char c) {
//            stack.push(c);
            stack.add(c);
        }

        private void enqueueCharacter(char c) {
            queue.add(c);
        }

        public char popCharacter() {
//            return stack.pop();
            char c = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return c;
        }

        public char dequeueCharacter() {
//            return queue.poll();
//            return queue.remove();
            char c = stack.get(0);
            stack.remove(0);
            return c;
        }
    }

    @Test
    public void day18_queueAndStacks() {
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        scan.close();

//        String input = "racecar";
        String input = "abcba";

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution_day18 p = new Solution_day18();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }
    // endregion

    // region day 17
    @Test
    public void day17_moreExceptions() {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//
//            int n = in.nextInt();
//            int p = in.nextInt();
        Calculator_day17 myCalculator = new Calculator_day17();
        try {
            int ans = myCalculator.power(-3, 5);
            System.out.println(ans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        }
//        in.close();
    }

    class Calculator_day17 {

        public int power(int n, int p) throws Exception {
            int result = 1;

            if (n < 0 || p < 0) {
                throw new Exception("n and p should be non-negative");
            }

            for (int i = 1; i <= p; i++) {
                result = result * n;
            }

            return result;
        }
    }
    // endregion

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
            head = insert15(head, N);
        }
        display15(head);
//        sc.close();
    }

    // 고정
    private void display15(Node head) {
        Node start = head;
        while (start != null) {
            System.out.println(start.data + " ");
            start = start.next;
        }
    }

    private Node insert15(Node head, int data) {
        // Complete this method
        System.out.println("head = " + head + ", data = " + data);

        if (head == null) {
            return new Node(data);
        } else if (head.next == null) {
            head.next = new Node(data);
        } else {
            insert15(head.next, data);
        }

        return head;
    }
    // endregion

    // region day 14
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
    // endregion

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
