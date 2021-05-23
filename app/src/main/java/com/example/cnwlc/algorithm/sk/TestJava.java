package com.example.cnwlc.algorithm.sk;

import java.util.ArrayList;
import java.util.Stack;

public class TestJava {
    public void main() {
        Tree tree01 = new Tree(
                1,
                new Tree(2,
                        new Tree(3,
                                new Tree(2, null, null),
                                null
                        ),
                        new Tree(6, null, null)
                ),
                new Tree(3,
                        new Tree(3, null, null),
                        new Tree(1,
                                new Tree(5, null, null),
                                new Tree(6, null, null)
                        )
                )
        ); // 3

        Tree tree02 = new Tree(
                1,
                new Tree(2,
                        new Tree(1, null, null),
                        new Tree(2, null, null)
                ),
                new Tree(2,
                        new Tree(4, null, null),
                        new Tree(1, null, null)
                )
        );    // 3
        Tree tree03 = new Tree(
                1,
                null,
                new Tree(2,
                        new Tree(1, null, null),
                        new Tree(1,
                                new Tree(4, null, null),
                                null
                        )
                )
        ); // 2
        Tree tree04 = new Tree(
                1,
                new Tree(2,
                        new Tree(3,
                                new Tree(2, null, null),
                                null
                        ),
                        new Tree(6, null, null)
                ),
                new Tree(3,
                        new Tree(3, null, null),
                        new Tree(1,
                                new Tree(5, null, null),
                                new Tree(6, null, null)
                        )
                )
        ); // 4
        System.out.println(solution(tree01));
//        System.out.println(solution(tree02));
//        System.out.println(solution(tree03));
//        System.out.println(solution(tree04));
    }

    public static int solution(Tree T) {
        ArrayList<Integer> list = new ArrayList<>();
        return solve(T, 0, list, "");
    }

    private static int solve(Tree node, int depth, ArrayList<Integer> list, String a) {
        System.out.print("a = "+a+", depth = "+depth);
        if (node == null) {
            System.out.println(" end");
            return depth;
        }
        System.out.print(", x = "+node.x);
        if (node.l != null)
            System.out.print(", l = "+node.l.x);
        if (node.r != null)
            System.out.println(", r = "+node.r.x);
        else System.out.println("");

        list.add(node.x);

        for (int i = 0; i< list.size()-1; i++) {
            System.out.println("list.get("+i+") = "+list.get(i));
            if (list.get(i) == node.x) {
                System.out.println("leftDepth = "+depth);
                return depth;
            }
        }

        int left = solve(node.l, depth+1, list, "left");
        list.clear();
        int right = solve(node.r, depth+1, list, "right");

        System.out.println("left = "+left +", right = "+right);

        return Math.max(left, right);
    }

    private static int solve(Tree node, int depth) {
        if (node == null) {
            return depth;
        }

        int left = solve(node.l, depth+1);
        int right = solve(node.r, depth+1);
        return Math.max(left, right);
    }
}