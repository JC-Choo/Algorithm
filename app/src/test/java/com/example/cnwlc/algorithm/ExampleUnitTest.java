package com.example.cnwlc.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        int[] a = {1, 3, 2, 4, 2};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println("answer = " + solution(3));
        System.out.println("answer = " + solution(7));
        System.out.println("answer = " + solution(11));
        System.out.println("answer = " + solution(15));
        long end = System.currentTimeMillis();
        System.out.println("수행시간 : " + (end - start));
    }

    // 124 나라의 숫자
    // 1. 124나라에는 자연수만 존재합니다.
    // 2. 124나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
    public String solution(int n) {
        String answer = "";
        int reminder;

        while(n>0){
            reminder = n%3;
            n = n/3;

            if(reminder == 0){
                n -= 1;
                reminder = 4;
            }

            answer = reminder + answer;
        }

        return answer;
    }

//    // 모의고사
//    // 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, //(5)1, 2, 3, 4, 5, ...
//    // 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, //(8) 2, 1, 2, 3, 2, 4, 2, 5, ...
//    // 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, //(10) 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
//    public int[] solution(int[] answers) {
//        int[] first = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
//                1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
//                1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
//                1, 2, 3, 4, 5, 1, 2, 3, 4, 5};  // 5
//        int[] second = {2, 1, 2, 3, 2, 4, 2, 5,
//                2, 1, 2, 3, 2, 4, 2, 5,
//                2, 1, 2, 3, 2, 4, 2, 5,
//                2, 1, 2, 3, 2, 4, 2, 5,
//                2, 1, 2, 3, 2, 4, 2, 5};    // 8
//        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
//                3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
//                3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
//                3, 3, 1, 1, 2, 2, 4, 4, 5, 5};   // 10
//
//        int[] testFirst = {1, 2, 3, 4, 5};
//        int[] testSecond = {2, 1, 2, 3, 2};
//        int[] testThird = {3, 3, 1, 1, 2};
//        int firstIndex = 0;
//        int secondIndex = 0;
//        int thirdIndex = 0;
//
//        int[] result = new int[3];
//
//        for(int i=0; i<answers.length; i++) {
//            if(testFirst[i] == answers[i]) firstIndex++;
//            if(testSecond[i] == answers[i]) secondIndex++;
//            if(testThird[i] == answers[i]) thirdIndex++;
//        }
//
//        result[0] = firstIndex;
//        result[1] = secondIndex;
//        result[2] = thirdIndex;
//
//        Arrays.sort(result);
//        return result;
//    }

//    // 자릿수 더하기
//    int solution(int n) {
//        int answer = 0;
//
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");
//
//        String str = String.valueOf(n);
//        for(int i=0; i<str.length(); i++) {
//            answer+= Integer.parseInt(String.valueOf(str.charAt(i)));
//        }
//        return answer;
//    }

//    // 이상한 문자 만들기
//    public String solution(String s) {
//        StringBuilder answer = new StringBuilder();
//        String[] firstStrings = s.split(" ");
//
//        int stringLength = s.length();
//
//        for(int i=0; i<firstStrings.length; i++) {
//            String[] secondStrings = firstStrings[i].split("");
//            StringBuilder result = new StringBuilder();
//            for(int j=0; j<secondStrings.length; j++) {
//                if(!secondStrings[j].isEmpty()) {
//                    if(j%2 == 0) result.append(secondStrings[j].toUpperCase());
//                    else result.append(secondStrings[j].toLowerCase());
//                }
//            }
//            if(i != firstStrings.length-1) answer.append(result).append(" ");
//            else answer.append(result);
//        }
//
//        int length = stringLength-answer.toString().length();
//        if(length != 0)
//            for(int i=0; i<=stringLength-answer.toString().length(); i++)
//                answer.append(" ");
//
//        return answer.toString();
//    }

//    public int solution(int[] d, int budget) {
//        int answer = 0;
//        int result = 0;
//        Arrays.sort(d);
//        for(int i=0; i<d.length; i++) {
//            result += d[i];
//            if(result > budget) {
//                answer = i;
//                break;
//            }
//        }
//        if(result <= budget) {
//            answer = d.length;
//        }
//        return answer;
//
////        for (int i = 0; i < d.length; i++) {
////            budget -= d[i];
////            if (budget < 0) break;
////            answer++;
////        }
//    }

//    // 소수찾기
//    private int solution(int num) {
//        int result = 0;
//        for(int i=2; i<=num; i++) {
//            boolean isPrime = true;
//            for(int j=2; j*j<=i; j++) {
//                if(i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//
//            if(isPrime)
//                result++;
//        }
//        return result;
////        ArrayList<Integer> arrayList = new ArrayList<>();
////        arrayList.add(2);
////        boolean isPassedIndex = true;
////        for(int i=3; i<=num; i++) {
////            for(int j=0; j<arrayList.size(); j++) {
////                if(i%arrayList.get(j) == 0) {
////                    isPassedIndex = false;
////                    break;
////                }
////            }
////            if(isPassedIndex)
////                arrayList.add(i);
////            isPassedIndex = true;
////        }
////        return arrayList.size();
//    }

//    // 시저암호
//    public String solution(String s, int n) {
//        String answer = "";
//
//        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
//        String upperAlphabet = lowerAlphabet.toUpperCase();
//
//        String[] upperA = upperAlphabet.split("");
//        String[] lowerA = lowerAlphabet.split("");
//        String[] input = s.split("");
//
//        for(int i=0; i<input.length; i++) {
//            int value = 0;
//            for(int j=0; j<upperA.length; j++) {
//                if(input[i].equals(upperA[j])) {
//                    value = j+n;
//                    if(value >= 26) value -= 26;
//                    answer += upperA[value];
//                    break;
//                } else if(input[i].equals(lowerA[j])) {
//                    value = j+n;
//                    if(value >= 26) value -= 26;
//                    answer += lowerA[value];
//                    break;
//                } else if(" ".equals(input[i])){
//                    answer += " ";
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
//    String caesar(String s, int n) {
//        String result = "";
//        n = n % 26;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (Character.isLowerCase(ch)) {
//                ch = (char) ((ch - 'a' + n) % 26 + 'a');
//            } else if (Character.isUpperCase(ch)) {
//                ch = (char) ((ch - 'A' + n) % 26 + 'A');
//            }
//            result += ch;
//        }
//        return result;
//    }


//    // 수박수박수박수?
//    public String solution(int n) {
//        String answer = "";
//        ArrayList<String> arrayList = new ArrayList<>();
//        for(int i=1; i<=n; i++) {
//            if(i%2 != 0) arrayList.add("수");
//            else arrayList.add("박");
//        }
//
//        for(int i=0; i<arrayList.size(); i++)
//            answer += arrayList.get(i);
//        return answer;
//
////        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
//    }

//    // 문자열 내림차순으로 배치하기
//    private String solution(String s) {
//        StringBuilder answer = new StringBuilder();
//        List<Character> upperList = new ArrayList<>();
//        List<Character> lowerList = new ArrayList<>();
//
//        for(int i=0; i<s.length(); i++) {
//            if (Character.isUpperCase(s.charAt(i))) {
//                upperList.add(s.charAt(i));
//            } else if (Character.isLowerCase(s.charAt(i))) {
//                lowerList.add(s.charAt(i));
//            }
//        }
//
//        // 오름차순 정렬
//        Collections.sort(lowerList);
//        Collections.sort(upperList);
//        // 내림차순 정렬
//        Collections.reverse(lowerList);
//        Collections.reverse(upperList);
//        for(int i=0; i<lowerList.size(); i++) {
//            answer.append(lowerList.get(i));
//        }
//        for(int i=0; i<upperList.size(); i++) {
//            answer.append(upperList.get(i));
//        }
//
//        return answer.toString();

    // 2번.. 대단하다
//        char[] sol = str.toCharArray();
//        Arrays.sort(sol);
//        return new StringBuilder(new String(sol)).reverse().toString();

    // 3번
//        String[] arry = str.split("");
//        Arrays.sort(arry,  Collections.reverseOrder());
//        StringBuffer sb = new StringBuffer();
//        for( String s : arry )
//        {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
//    // String으로 내림차순(Desc) 정렬
//    static class CompareNameDesc implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            // TODO Auto-generated method stub
//            return o2.compareTo(o1);
//        }
//    }
//    // String으로 오름차순(Asc) 정렬
//    static class CompareNameAsc implements Comparator<String>{
//        @Override
//        public int compare(String o1, String o2) {
//            // TODO Auto-generated method stub
//            return o1.compareTo(o2);
//        }
//    }

//    // 문자열 다루기 기본
//    private boolean solution(String s) {
//        return Pattern.compile("(^[0-9]*$)").matcher(s).find();
//    }
//    public static boolean isNum(String s) {
//        int length = s.length();
//        if(length != 4 && length != 6) return false;
//        for(int i=0; i<length; i++) {
//            char c = s.charAt(i);
//            if(c < '0' || c > '9') {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static boolean isChecked2(String s) {
//        if(s.length() == 4 || s.length() == 6) {
//            try {
//                int x = Integer.parseInt(s);
//                return true;
//            } catch (NumberFormatException e) {
//                return false;
//            }
//        }
//        return false;
//    }
}