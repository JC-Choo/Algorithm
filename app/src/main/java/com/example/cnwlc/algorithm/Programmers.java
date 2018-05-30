package com.example.cnwlc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programmers {
    private Programmers() {
    }

    private static class SingleTon {
        public static final Programmers Instance = new Programmers();
    }

    public static Programmers getInstance() {
        return SingleTon.Instance;
    }

    // 가운데 글자 가져오기
    public String getMiddelChar(String word) {
        if (word.length() % 2 == 0) {
            return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
        } else {
            return word.substring(word.length() / 2, word.length() / 2 + 1);
        }
    }

    // 최대공약수와 최소공배수(Maximum common divisor and minimum common multiple.)
    public int[] getMaxAndMin(int a, int b) {
        int[] answer = new int[2];
        if (a <= b) {
            for (int j = 1; j <= b; j++) {
                for (int i = 1; i <= a; i++) {
                    if (a % i == 0 && b % i == 0) {
                        answer[0] = i;
                    }
                }
            }
        }
        answer[1] = (a * b) / answer[0];

        return answer;
    }

    // 스트링을 숫자로 바꾸기
    public int getStrToInt(String str) {
        return Integer.valueOf(str);
    }

    // 피보나치 수
    public long fibonacci(int num) {
        long answer = 0;

        if (num >= 2) {
            int[] baNum = new int[num + 1];
            baNum[0] = 0;
            baNum[1] = 1;

            for (int i = 2; i <= num; i++) {
                baNum[i] = baNum[i - 1] + baNum[i - 2];
            }

            answer = baNum[num];
        }

        return answer;
    }

    // 서울에서 김서방 찾기
    public String findKim(String[] seoul) {
        //x에 김서방의 위치를 저장하세요.
        int x = 0;

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                x = i;
            }
        }

        return "김서방은 " + x + "에 있다";
    }

    // 약수의 합
    public int sumDivisor(int num) {
        int answer = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    // 나누어 떨어지는 숫자 배열
    public int[] divisible(int[] array, int divisor) {
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % divisor == 0) {
                j++;
            }
        }
        int[] ret = new int[j];

        j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % divisor == 0) {
                ret[j] = array[i];
                j++;
            }
        }

        return ret;
    }

    // 최대값과 최소값
    public String getMinMaxString(String str) {
        String[] dividedStr = str.split(" ");
        int value, min = Integer.valueOf(dividedStr[0]), max = Integer.valueOf(dividedStr[0]);

        for (int i = 1; i < dividedStr.length; i++) {
            value = Integer.parseInt(dividedStr[i]);
            if (min > value) min = value;
            if (max < value) max = value;
        }

        return min + " " + max;
    }

    // 2016년

    /**
     * 2016년 1월 1일 금요일, 2016년 a월 b일은 무슨요일?
     * 2016년은 윤년(2월29일까지 있음), 요일은 SUN, MON, TUE, WED, THU, FRI, SAT
     */
    public String get2016(int a, int b) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int totalDay = 0;
        for (int i = 0; i < month[a]; i++) {
            totalDay += days[i];
        }

        if (((totalDay + b) % 7) == 0) {
            return week[(totalDay + b) % 7 + 6];
        } else {
            return week[(totalDay + b) % 7 - 1];
        }
    }

    // 가장 긴 팰린드롬(앞뒤를 뒤집어도 똑같은 문자열)

    /**
     * 문자열 s가 abcdcba 이면 7을 return
     * abacde 이면 3을 return
     */
    public int getPalindrome(String s) {
        System.out.println("getPalindrome example s = " + s);
        int answer = 0;

        List<Integer> integerList1 = new ArrayList<>();
        for (int a = 0; a < s.length(); a++) {            // 기준 인덱스
            for (int b = 0; b < s.length(); b++) {       // 비교 인덱스
                if (s.charAt(a) == s.charAt(b) && b != a) {
                    integerList1.add(a);
                }
            }
        }

        List<Integer> integerList2 = new ArrayList<>();
        for (int b = 0; b < integerList1.size() - 1; b++) {
            if ((integerList1.get(b) + 1) != integerList1.get(b + 1)) {
                integerList2.add(integerList1.get(b) + 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        if (integerList2.size() > 0) {
            int firstResult = (integerList2.get(0) - integerList1.get(0) + 1) * 2 - 1;
            int data = 0;
            for (int b = 0; b < integerList2.size(); b++) {

                if (b > 0) {
                    data = (integerList2.get(b) - firstResult + 1) * 2 - 1;
                    firstResult += data;
                }
                if (data == 0) {
                    data = firstResult;
                }
                resultList.add(data);
            }

            Ascending ascending = new Ascending();
            Collections.sort(resultList, ascending);
            for (Integer integer : resultList) {
                System.out.print(integer + " ");
            }
        }

        return answer;
    }
    // 오름차순
    class Ascending implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }


    // 같은 숫자는 싫어
    public int[] getDontHateSameCount(int []arr) {
        System.out.println("getDontHateSameCount arr = " + Arrays.toString(arr));

        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++) {
            int same = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                if(same != arr[j]) {
                    integerList.add(same);
                    break;
                } else
                    break;
            }
        }
        integerList.add(arr[arr.length-1]);

        int[] answer = new int[integerList.size()];
        for(int i=0; i<integerList.size(); i++) {
            answer[i] = integerList.get(i);
        }

        return answer;
    }
}
