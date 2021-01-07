package com.example.cnwlc.algorithm.hacker_rank.kakao2;

import android.util.Range;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestK {

    @Test
    public void test() {

    }



    // Sample - Q2
    private List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i%2 == 1) {
                list.add(i);
            }
        }
        return list;
    }

    // Sample - Q1
    private String findNumber(List<Integer> arr, int k) {
        String result = "NO";
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) == k) {
                result = "YES";
                break;
            }
        }
        return result;
    }
}
