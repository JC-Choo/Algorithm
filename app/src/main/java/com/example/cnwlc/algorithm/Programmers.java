package com.example.cnwlc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
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

    // 문자열 내 마음대로 정렬하기
//    public String[] solution(String[] strings, int n) {
//        // n번째 인덱스 글자 기준으로 오름차순 정렬.
//        // 1. strings의 길이는 1이상 50이하 배열
//        // 2. strings 원소는 소문자
//        // 3. 원소 길이는 1이상 100이하 문자열
//        // 4. strings의 원소 길이는 n보다 큼
//        // 5. 인덱스 1의 문자가 같은 문자열이 여럿일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치
//
//        String[] answer={""};
//        ArrayList<String> list = new ArrayList<>();
//        for(int i=0; i<strings.length; i++)
//            list.add(strings[i].charAt(n)+strings[i]);
//
//        Collections.sort(list);
//
//        answer = new String[list.size()];
//        for(int i=0; i<list.size(); i++)
//            answer[i] = list.get(i).substring(1, list.get(i).length());
//
////        String[] answer = new String[strings.length];
////        char[] chars = new char[strings.length];
////
////        for(int i=0; i<strings.length; i++) {
////            chars[i] = strings[i].charAt(n);
////        }
////
////        Arrays.sort(chars);
////
////        for(int i=0; i<strings.length; i++) {
////            for(int j=0; j<strings.length; j++) {
////                if(chars[i] == strings[j].charAt(n)
////                        && !strings[j].equals(answer[j])) {
////                    answer[i]  = strings[j];
////                    break;
////                }
////            }
////        }
////
////        if(chars[0] == chars[1] )
////            Arrays.sort(answer, String.CASE_INSENSITIVE_ORDER);
//
//        return answer;
//    }
    public String[] solution(String[] strings, int n) {
        // strings range - 1 ~ 50
        // strings element - 1 ~ 100

        // == 버블정렬 ==
        int range = strings.length - 1;
        for(int i=0; i<range; i++) {
            for(int j=0; j<(range)-i; j++) {
                if(compareString(strings[j], strings[j+1], n, n)) {
                    swapString(strings, j, j+1);
                }
            }
        }

        return strings;
    }
    public boolean compareString(String a, String b, int n, int now) {
        if(a.charAt(now) > b.charAt(now))
            return true;
        else if(a.charAt(now) == b.charAt(now)) {
            int next = n == now ? 0 : ++now;
            if(n == next) next++;
            return compareString(a, b, n, next);
        } else {
            return false;
        }
    }
    public void swapString(String[] strings, int a, int b) {
        String temp = strings[a];
        strings[a] = strings[b];
        strings[b] = temp;
    }

//    // 문자열 내 p와 y의 개수
//    boolean solution(String s) {
//        boolean answer = true;
//
//        // 1번
//        String[] str = s.split("");
//        int countOfP = 0;
//        int countOfY = 0;
//
//        for(int i=0; i<s.length(); i++) {
//            if(str[i].equals("P") || str[i].equals("p")) {
//                countOfP++;
//            } else if(str[i].equals("Y") || str[i].equals("y")) {
//                countOfY++;
//            }
//        }
//
//        if(countOfP == countOfY) answer = true;
//        else answer = false;
//
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");
//
//        // 2번
//        s = s.toUpperCase();
//        answer = s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
//
//        return answer;
//    }

//    // 두 정수 사이의 합
//    public long solution(int a, int b) {
//        /**
//         * 조건 1. a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
//         * 조건 2. a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
//         * 조건 3. a와 b의 대소관계는 정해져있지 않습니다.
//         */
//        long answer = 0;
//
//        // 1번
//        if( a < b) {
//            for(int i=a; i<=b; i++) {
//                answer += i;
//            }
//        } else if( a == b ) {
//            answer = a;
//            return answer;
//        } else {
//            for(int i=b; i<=a; i++) {
//                answer += i;
//            }
//        }
//
//        // 2번
//        for(int i=Math.min(a, b); i <= Math.max(a, b); i++) {
//            answer += i;
//        }
//
//        return answer;
//    }

//    // 같은 숫자는 싫어
//    public int[] hateSameNumber(int[] arr) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int temp = -1;
//        for(int i: arr) {
//            if(temp == i) {}
//            else list.add(i);
//            temp = i;
//        }
//        int[] answer = new int[list.size()];
//        for(int i=0; i<list.size(); i++)
//            answer[i] = list.get(i);
//
//        return answer;
//    }

//    // 체육복 : n(전체 학생 수), lost(잃어버린 학생 번호 배열), reserve(예비 체육복 가진 학생 번호 배열)
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = 0;     // 체육 수업을 들을 수 있는 학생의 최댓값
//        int numberOfLostStudent = 0;  // 잃어버린 학생의 수
//        int[] allOfStudentsHavingClose = new int[n];    // 전체 학생이 가지고 있는 체육복의 개수
//        for(int i=0; i<allOfStudentsHavingClose.length; i++) {
//            allOfStudentsHavingClose[i] = 1;    // 하나씩 가지고 있다고 가정
//        }
//
//        for (int aReserve : reserve) {
//            allOfStudentsHavingClose[aReserve - 1] += 1;    // 예비로 가지고 있는 학생의 번호에(배열이니 0부터) +1
//        }
//
//        for(int i=0; i<lost.length; i++) {
//            allOfStudentsHavingClose[lost[i]-1] -= 1;   // 체육복을 잃어버린 학생의 번호(배열이니 0부터) -1
//            if(allOfStudentsHavingClose[lost[i]-1] == 0)
//                numberOfLostStudent += 1;       // 해당 번호 학생이 체육복이 없다면(0이라면) 없는 학생 수 +1
//        }
//
//        for(int i=0; i<allOfStudentsHavingClose.length; i++) {
//            if(allOfStudentsHavingClose[i] == 0) {
//                if(i == 0
//                        && allOfStudentsHavingClose[i+1] == 2) {  // i가 0 일때 i+1 이 2여야만 체육복을 빌려줄 수 있음
//                    allOfStudentsHavingClose[i] += 1;
//                    allOfStudentsHavingClose[i+1] -= 1;
//                    numberOfLostStudent -= 1;
//                } else if(i == allOfStudentsHavingClose.length-1
//                        && allOfStudentsHavingClose[i-1] == 2) {    // i가 마지막일때, i-1 이 0이여야만 빌려줄 수 있음
//                    allOfStudentsHavingClose[i-1] -= 1;
//                    allOfStudentsHavingClose[i] += 1;
//                    numberOfLostStudent -= 1;
//                } else if(i != 0
//                        && allOfStudentsHavingClose[i-1] == 2) {    // 0이 아닐 때, i-1이 2여야만 빌려줄 수 있음
//                    allOfStudentsHavingClose[i-1] -= 1;
//                    allOfStudentsHavingClose[i] += 1;
//                    numberOfLostStudent -= 1;
//                } else if(i != allOfStudentsHavingClose.length-1
//                        && allOfStudentsHavingClose[i+1] == 2) {    // 마지막이 아닐 때, i+1이 2여야만 빌려줄 수 있음
//                    allOfStudentsHavingClose[i] += 1;
//                    allOfStudentsHavingClose[i+1] -=1;
//                    numberOfLostStudent -= 1;
//                }
//            }
//        }
//
//        answer = n - numberOfLostStudent;
//        return answer;
//    }


    /** 모의고사 문제 이해 안감*/
//    public int[] test(int[] answers) {
//        int[] answer = {};
//        return answer;
//    }

//    // 기능개발
//    private int result = 1, index = 0;
//    public int[] functionDevelopment(int[] progresses, int[] speeds) {
//        int[] answer = new int[progresses.length];
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < progresses.length; i++) {
//            for (int j = 1; j <= 100 / speeds[i]; j++) {
//                if (progresses[i] + (speeds[i] * j) >= 100) {
//                    arrayList.add(j);
//                    break;
//                }
//            }
//        }
//
//        answer[0] = result;
//        for (int i = 1; i < arrayList.size(); i++) {
//            if (arrayList.get(0) <= arrayList.get(i)) {
//                index++;
//                answer[index] = result;
//                System.out.println("if result = "+result+", index = "+index);
//            } else {
//                result++;
//                answer[0] = result;
//                System.out.println("else result = "+result);
//            }
//            result = 1;
//        }
//
//        for(int i=0; i<answer.length; i++) {
//            System.out.println("answer["+i+"] = "+answer[i]);
//        }
//
//        int resultIndex = 0;
//        for (int anAnswer : answer) {
//            if (anAnswer != 0) {
//                resultIndex++;
//            } else break;
//        }
//
//        int[] result = new int[resultIndex];
//        System.arraycopy(answer, 0, result, 0, resultIndex);
//
//        return result;
//    }

    // 기능개발 파트 2
//    private int[] functionDevelopments(int[] progresses, int[] speeds) {
//        Queue<Integer> q = new LinkedList<>();
//        Queue<Integer> answer = new LinkedList<>();
//
////각 작업 당 필요한 일수를 구한 뒤 큐에 넣는다
//        for(int i=0; i<progresses.length; i++){
//            int needDay = (100-progresses[i])/speeds[i];
//            if((100-progresses[i])%speeds[i]!=0) needDay++;
//            q.offer(needDay);
//        }
//
//
//        while ( !q.isEmpty() ){
//
//            int unit = q.poll();
//            int count=1;
//            while ( !q.isEmpty() && unit >= q.peek()){
//                q.poll();
//                count++;
//            }
//            answer.offer(count);
//        }
//
//
//        int answerSize = answer.size();
//        int[] result = new int[answerSize];
//        for(int i=0; i<answerSize; i++){
//            result[i] = answer.poll();
//        }
//
//        return result;
//    }

    // N으로 표현
    /** 모르겠음 */
//    public int representN(int N, int number) {
//        if(N <= 0 || N > 9) return 0;
//
//        int answer = 0;
//
//        if(answer > 8) return -1;
//
//        return answer;
//    }

    // 완주하지 못한 선수 1번
//    public String getNoCompletionPlayer(String[] participant, String[] completion) {
//        String answer = "";
//
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String name : participant) {
//            if (map.get(name) == null) {
//                map.put(name, 0);
//            } else {
//                int value = map.get(name) + 1;
//                map.put(name, value);
//            }
//        }
//
//        for (String name : completion) {
//            int value = map.get(name) - 1;
//            map.put(name, value);
//        }
//
//        for (String name : map.keySet()) {
//            if (map.get(name) == 0) answer = name;
//        }
//
//        return answer;
//    }
    // 완주하지 못한 선수 2번
//    public String getNoCompletionPlayer(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        for (int i=0; i<completion.length; i++){
//            if (!participant[i].equals(completion[i])){
//                return participant[i];
//            }
//        }
//        return null;
//    }

//
//    // 가운데 글자 가져오기
//    public String getMiddelChar(String word) {
//        if (word.length() % 2 == 0) {
//            return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
//        } else {
//            return word.substring(word.length() / 2, word.length() / 2 + 1);
//        }
//    }
//
//    // 최대공약수와 최소공배수(Maximum common divisor and minimum common multiple.)
//    public int[] getMaxAndMin(int a, int b) {
//        int[] answer = new int[2];
//        if (a <= b) {
//            for (int j = 1; j <= b; j++) {
//                for (int i = 1; i <= a; i++) {
//                    if (a % i == 0 && b % i == 0) {
//                        answer[0] = i;
//                    }
//                }
//            }
//        }
//        answer[1] = (a * b) / answer[0];
//
//        return answer;
//    }
//
//    // 스트링을 숫자로 바꾸기
//    public int getStrToInt(String str) {
//        return Integer.valueOf(str);
//    }
//
//    // 피보나치 수
//    public long fibonacci(int num) {
//        long answer = 0;
//
//        if (num >= 2) {
//            int[] baNum = new int[num + 1];
//            baNum[0] = 0;
//            baNum[1] = 1;
//
//            for (int i = 2; i <= num; i++) {
//                baNum[i] = baNum[i - 1] + baNum[i - 2];
//            }
//
//            answer = baNum[num];
//        }
//
//        return answer;
//    }
//
//    // 서울에서 김서방 찾기
//    public String findKim(String[] seoul) {
//        //x에 김서방의 위치를 저장하세요.
//        int x = 0;
//
//        for (int i = 0; i < seoul.length; i++) {
//            if (seoul[i].equals("Kim")) {
//                x = i;
//            }
//        }
//
//        return "김서방은 " + x + "에 있다";
//    }
//
//    // 약수의 합
//    public int sumDivisor(int num) {
//        int answer = 0;
//
//        for (int i = 1; i <= num; i++) {
//            if (num % i == 0) {
//                answer += i;
//            }
//        }
//
//        return answer;
//    }
//
//    // 나누어 떨어지는 숫자 배열
//    public int[] divisible(int[] array, int divisor) {
//        int j = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % divisor == 0) {
//                j++;
//            }
//        }
//        int[] ret = new int[j];
//
//        j = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % divisor == 0) {
//                ret[j] = array[i];
//                j++;
//            }
//        }
//
//        return ret;
//    }
//
//    // 최대값과 최소값
//    public String getMinMaxString(String str) {
//        String[] dividedStr = str.split(" ");
//        int value, min = Integer.valueOf(dividedStr[0]), max = Integer.valueOf(dividedStr[0]);
//
//        for (int i = 1; i < dividedStr.length; i++) {
//            value = Integer.parseInt(dividedStr[i]);
//            if (min > value) min = value;
//            if (max < value) max = value;
//        }
//
//        return min + " " + max;
//    }
//
//    // 2016년
//
//    /**
//     * 2016년 1월 1일 금요일, 2016년 a월 b일은 무슨요일?
//     * 2016년은 윤년(2월29일까지 있음), 요일은 SUN, MON, TUE, WED, THU, FRI, SAT
//     */
//    public String get2016(int a, int b) {
//        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        int[] month = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
//
//        int totalDay = 0;
//        for (int i = 0; i < month[a]; i++) {
//            totalDay += days[i];
//        }
//
//        if (((totalDay + b) % 7) == 0) {
//            return week[(totalDay + b) % 7 + 6];
//        } else {
//            return week[(totalDay + b) % 7 - 1];
//        }
//    }
//
//    // 가장 긴 팰린드롬(앞뒤를 뒤집어도 똑같은 문자열)
//
//    /**
//     * 문자열 s가 abcdcba 이면 7을 return
//     * abacde 이면 3을 return
//     */
//    public int getPalindrome(String s) {
//        System.out.println("getPalindrome example s = " + s);
//        int answer = 0;
//
//        List<Integer> integerList1 = new ArrayList<>();
//        for (int a = 0; a < s.length(); a++) {            // 기준 인덱스
//            for (int b = 0; b < s.length(); b++) {       // 비교 인덱스
//                if (s.charAt(a) == s.charAt(b) && b != a) {
//                    integerList1.add(a);
//                }
//            }
//        }
//
//        List<Integer> integerList2 = new ArrayList<>();
//        for (int b = 0; b < integerList1.size() - 1; b++) {
//            if ((integerList1.get(b) + 1) != integerList1.get(b + 1)) {
//                integerList2.add(integerList1.get(b) + 1);
//            }
//        }
//
//        List<Integer> resultList = new ArrayList<>();
//        if (integerList2.size() > 0) {
//            int firstResult = (integerList2.get(0) - integerList1.get(0) + 1) * 2 - 1;
//            int data = 0;
//            for (int b = 0; b < integerList2.size(); b++) {
//
//                if (b > 0) {
//                    data = (integerList2.get(b) - firstResult + 1) * 2 - 1;
//                    firstResult += data;
//                }
//                if (data == 0) {
//                    data = firstResult;
//                }
//                resultList.add(data);
//            }
//
//            Ascending ascending = new Ascending();
//            Collections.sort(resultList, ascending);
//            for (Integer integer : resultList) {
//                System.out.print(integer + " ");
//            }
//        }
//
//        return answer;
//    }
//
//    // 오름차순
//    class Ascending implements Comparator<Integer> {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1.compareTo(o2);
//        }
//    }
//
//
//    // 같은 숫자는 싫어
//    public int[] getDontHateSameCount(int[] arr) {
//        System.out.println("getDontHateSameCount arr = " + Arrays.toString(arr));
//
//        List<Integer> integerList = new ArrayList<>();
//        for (int i = 0; i < arr.length - 1; i++) {
//            int same = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                if (same != arr[j]) {
//                    integerList.add(same);
//                    break;
//                } else
//                    break;
//            }
//        }
//        integerList.add(arr[arr.length - 1]);
//
//        int[] answer = new int[integerList.size()];
//        for (int i = 0; i < integerList.size(); i++) {
//            answer[i] = integerList.get(i);
//        }
//
//        System.out.println(answer);
//        return answer;
//    }
//
//    // 올바른 괄호(Parenthesis)
//    char a = '(', b = ')';
//    private List<Integer> integerList1, integerList2;
//    boolean getParenthesis(String str) {
//        integerList1 = getIndexNumber(str, a);
//        integerList2 = getIndexNumber(str, b);
//
//        boolean answer = false;
//        int aCount = 0, bCount = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == a)
//                aCount++;
//            if (str.charAt(i) == b)
//                bCount++;
//        }
//
//        if( aCount == bCount ) {
//            answer = true;
//            for(int i=0; i < aCount; i++) {
//                if(integerList1.get(i) > integerList2.get(i)) {
//                    answer = false;
//                    break;
//                }
//            }
//        }
//
//        System.out.println(answer);
//        return answer;
//    }
//    private List<Integer> getIndexNumber(String str, char c) {
//        List<Integer> integerList = new ArrayList<>();
//        int fromIndex = 0;
//        while(true) {
//            int count = str.indexOf(c, fromIndex);
//            if(count == -1)
//                break;
//            else {
//                integerList.add(count);
//                fromIndex = count + 1;
//            }
//        }
//        return integerList;
//    }
//
//    // 나누어 떨어지는 숫자 배열
//    public int[] dividedNumber(int[] arr, int divisor) {
//        List<Integer> integerList = new ArrayList<>();
//        for (int anArr : arr) {
//            if (anArr % divisor == 0)
//                integerList.add(anArr);
//        }
//
//        int[] answer = new int[integerList.size()];
//        if(integerList.size() > 0) {
//            for(int i=0; i<answer.length; i++) {
//                answer[i] = integerList.get(i);
//            }
//
//            int temp;
//            for(int i=0; i<answer.length-1; i++) {
//                for(int j=i+1; j<answer.length; j++) {
//                    if(answer[i] > answer[j]) {
//                        temp = answer[i];
//                        answer[i] = answer[j];
//                        answer[j] = temp;
//                    }
//                }
//            }
//        } else
//            answer = new int[]{-1};
//
//        return answer;
//
////        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
//    }
}
