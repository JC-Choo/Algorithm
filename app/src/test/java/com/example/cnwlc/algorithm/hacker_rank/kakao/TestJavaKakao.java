package com.example.cnwlc.algorithm.hacker_rank.kakao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJavaKakao {



    @Test
    public void test02() {
        List<Integer> test01 = oddNumbers(2, 5);
        List<Integer> test02 = oddNumbers(3, 9);
    }

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();

        for(int i=l; i<r; i++) {
            if(i%2 == 1) {
                result.add(i);
            }
        }

        return result;
    }

    @Test
    public void test01() {
        List<Integer> test01 = new ArrayList<Integer>();
        for(int i=0; i<5; i++) {
            test01.add(i);
        }
        System.out.println(findNumber(test01, 6));
    }

    public static String findNumber(List<Integer> arr, int k) {
        String result = "No";
        for (int i = 0; i<arr.size(); i++) {
            if(arr.get(i) == k) {
                result = "YES";
                break;
            }
        }

        return result;
    }
}
