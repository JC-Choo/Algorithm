package com.example.cnwlc.algorithm.hacker_rank;

import com.example.cnwlc.algorithm.hacker_rank.Person;

import org.junit.Test;

import java.util.Scanner;

public class HackerRankJava {

    @Test
    public void day4_class_vs_instance() {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = 4;
        for (int i = 0; i < T; i++) {
//            int age = sc.nextInt();
            Person p;
            if(i == 0) {
                p = new Person(-1);
            } else if(i == 1) {
                p = new Person(10);
            } else if( i == 2){
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
        System.out.println(i+x_int);

        x_double = scan.nextDouble();
        System.out.println(d+x_double);

        scan.nextLine();
        x_string = scan.nextLine();
        System.out.println(s+x_string);

        scan.close();
    }
}
