package com.example.cnwlc.algorithm.hacker_rank;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class InterviewPreparationKit {

    private Scanner scanner = new Scanner(System.in);

    @Test
    public void warmUpChallenge_sockMerchant() throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] ar = new int[n];
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }

        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(9, ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println("result = " + result);
        scanner.close();
    }
    // Complete the sockMerchant function below.
    private int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);

        Set<Integer> s = new HashSet<>();
        for (int value : ar) {
            if (!s.contains(value))
                s.add(value);
        }
        System.out.println(s);


        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int value : ar) {
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        for (int key : map.keySet()) {
            System.out.println("map[" + key + "] = " + map.get(key));

            if(map.get(key)/2 != 0) result += map.get(key)/2;

//            if(result < map.get(key))
//                result = map.get(key);
        }


        for (int i = 0; i < ar.length; i++) {
            System.out.println("ar[" + i + "] = " + ar[i]);
        }

        return result;
    }
}
