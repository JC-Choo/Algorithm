package com.example.cnwlc.algorithm.programmers;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class AlgorithmHash {
    @Test
    public void test() {
        String[] a1 = new String[]{"119", "97674223", "1195524421"};
        String[] b1 = new String[]{"123", "456", "789"};
        String[] c1 = new String[]{"12", "123", "1254", "567", "88"};

        System.out.println(phoneList(a1));
        System.out.println(phoneList(b1));
        System.out.println(phoneList(c1));
    }

    // phone_book : 전화번호부에 적힌 전화번호를 담은 배열
    // 어떤 번호가 다른 번호의 접두어인 경우 -> false, 접두어가 아닌 경우 -> true
    private boolean phoneList(String[] phone_book) {
        boolean answer = true;

//        Hash

        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].contains(phone_book[j]) ||
                        phone_book[j].contains(phone_book[i])) {
                    answer = false;
                }
            }
        }

        return answer;
    }

    // participant : 마라톤에 참여한 선수들의 이름이 담긴 배열
    // completion : 완주한 선수들의 이름이 담긴 배열
    // 완주하지 못한 선수의 이름을 리턴
    private String marathon(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        // region 내가 푼거
//        for (int i=0; i<participant.length; i++){
//            if(i == completion.length) {
//                return participant[i];
//            }
//
//            if (!participant[i].equals(completion[i])){
//                return participant[i];
//            }
//        }
//        return null;
        // endregion

        // region solution2
//        int i;
//        for(i= 0; i<completion.length; i++) {
//            if(!participant[i].equals(completion[i])) {
//                return participant[i];
//            }
//        }
//
//        return participant[i];
        // endregion

        // region solution3
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String player : participant) hashMap.put(player, hashMap.getOrDefault(player, 0)+1);
        for(String player : completion) hashMap.put(player, hashMap.get(player)-1);

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0) {
                return key;
            }
        }

        return null;
        // endregion
    }
}
