package com.example.cnwlc.algorithm.hacker_rank;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Solution27 {

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    static class TestDataEmptyArray {
        public static int[] get_array() {
            // complete this function : has to return an empty array.

            return new int[]{};
        }
    }

    static class TestDataUniqueValues {
        public static int[] get_array() {
            // complete this function : 모두 유니크한 요소를 가진 최소 2개의 사이즈의 어레이를 리턴
            return new int[]{1, 3};
        }

        public static int get_expected_result() {
            // complete this function : 어레이에 대한 최소 기댓갑의 인덱스를 리턴
            return 0;
        }
    }

    static class TestDataExactlyTwoDifferentMinimums {
        public static int[] get_array() {
            // complete this function : 두개의 다른 최소 값이 있는 어레이를 리턴
            return new int[]{1, 1};
        }

        public static int get_expected_result() {
            // complete this function : 어레이에 대한 최소 기댓갑을 리턴
            return 0;
        }
    }


    public static void TestWithEmptyArray() {
        try {
            int[] seq = TestDataEmptyArray.get_array();
            int result = minimum_index(seq);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Exception wasn't thrown as expected");
    }

    public static void TestWithUniqueValues() {
        int[] seq = TestDataUniqueValues.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        Integer[] tmp = new Integer[seq.length];
        for (int i = 0; i < seq.length; ++i) {
            tmp[i] = Integer.valueOf(seq[i]);
        }
        if (!((new LinkedHashSet<Integer>(Arrays.asList(tmp))).size() == seq.length)) {
            throw new AssertionError("not all values are unique");
        }

        int expected_result = TestDataUniqueValues.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void TestWithExactlyTwoDifferentMinimums() {
        int[] seq = TestDataExactlyTwoDifferentMinimums.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        int[] tmp = seq.clone();
        Arrays.sort(tmp);
        if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
            throw new AssertionError("there are not exactly two minimums in the array");
        }

        int expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    @Test
    public void day27() {
        TestWithEmptyArray();
        TestWithUniqueValues();
        TestWithExactlyTwoDifferentMinimums();
        System.out.println("OK");
    }
}
