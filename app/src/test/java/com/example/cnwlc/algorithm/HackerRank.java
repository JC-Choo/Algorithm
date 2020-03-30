package com.example.cnwlc.algorithm;

import org.junit.Test;

import java.util.Scanner;

public class HackerRank {
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
