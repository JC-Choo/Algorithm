package com.example.cnwlc.algorithm;

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
        if(a <= b) {
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

        if(num >= 2) {
            int[] baNum = new int[num+1];
            baNum[0] = 0;
            baNum[1] = 1;

            for(int i=2; i<=num; i++) {
                baNum[i] = baNum[i-1] + baNum[i-2];
            }

            answer = baNum[num];
        }

        return answer;
    }

    // 서울에서 김서방 찾기
    public String findKim(String[] seoul){
        //x에 김서방의 위치를 저장하세요.
        int x = 0;

        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                x = i;
            }
        }

        return "김서방은 "+ x + "에 있다";
    }

    // 약수의 합
    public int sumDivisor(int num) {
        int answer = 0;

        for(int i=1; i<=num; i++) {
            if(num%i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    // 나누어 떨어지는 숫자 배열
    public int[] divisible(int[] array, int divisor) {
        int j=0;

        for(int i=0; i< array.length; i++) {
            if(array[i]%divisor == 0) {
                j++;
            }
        }
        int[] ret = new int[j];

        j = 0;
        for(int i=0; i< array.length; i++) {
            if(array[i]%divisor == 0) {
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

        for(int i=1; i<dividedStr.length; i++) {
            value = Integer.parseInt(dividedStr[i]);
            if(min > value) min = value;
            if(max < value) max = value;
        }

        return min+" "+max;
    }
}
