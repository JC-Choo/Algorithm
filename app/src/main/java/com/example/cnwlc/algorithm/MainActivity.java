package com.example.cnwlc.algorithm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cnwlc.algorithm.test.CallAccessController;
import com.example.cnwlc.algorithm.test.TestAccessController;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestAccessController testAccessController = new TestAccessController();
        testAccessController.test02 = 20;
        testAccessController.print02();
        testAccessController.toString();
        System.out.println("--------------------------");

        CallAccessController cac = new CallAccessController();
        cac.main();

//        programmers();
//        RamenCook ramenCook = new RamenCook(10);
//        new Thread(ramenCook, "A").start();
//        new Thread(ramenCook, "B").start();
//        new Thread(ramenCook, "C").start();
//        new Thread(ramenCook, "D").start();
    }

    private void programmers() {
//        int[] a = {93, 30, 55};
//        int[] b = {1, 30, 5};
//        System.out.println("answer = "+ Arrays.toString(Programmers.getInstance().functionDevelopment(a, b)));


        String[] arr1 = {"sun", "bed", "car"};
        String[] arr2 = {"abce", "abcd", "cdx"};
        System.out.println("answer = "+ Arrays.toString(Programmers.getInstance().solution(arr1, 1)));

//        String[] a = {"mislav", "stanko", "mislav", "ana"};
//        String[] b = {"stanko", "mislav", "ana"};
//        System.out.println("answer = "+Programmers.getInstance().getNoCompletionPlayer(a, b));


//        System.out.println(Programmers.getInstance().getMiddelChar("power"));
//
//        System.out.println(Arrays.toString(Programmers.getInstance().getMaxAndMin(3, 12)));
//
//        System.out.println(Programmers.getInstance().getStrToInt("-1234"));
//
//        System.out.println(Programmers.getInstance().fibonacci(3));
//
//        String[] names = {"Queen", "Tod","Kim"};
//        System.out.println(Programmers.getInstance().findKim(names));
//
//        System.out.println(Programmers.getInstance().sumDivisor(12));
//
//        int[] array = {5, 9, 7, 10};
//        System.out.println( Arrays.toString(Programmers.getInstance().divisible(array, 5)));
//
//        String str = "1 2 3 4";
//        System.out.println("최대값과 최소값은?" + Programmers.getInstance().getMinMaxString(str));
//
//        System.out.println("1월 1일은 " + Programmers.getInstance().get2016(1, 1)+"DAY 입니다.");
//
//        System.out.println(Programmers.getInstance().getPalindrome("abacdedcfghihgf"));
//
//        System.out.println(Arrays.toString(Programmers.getInstance().getDontHateSameCount(new int[]{1, 1, 3, 3, 0, 1, 1})));
//
//        System.out.println(Programmers.getInstance().getParenthesis("())(()"));
//        System.out.println(Programmers.getInstance().getParenthesis("(())()"));
//
//        System.out.println(Arrays.toString(Programmers.getInstance().dividedNumber(new int[]{1, 5, 10, 3, 2}, 5)));
//        System.out.println(Arrays.toString(Programmers.getInstance().dividedNumber(new int[]{1, 6, 3, 4, 2, 5}, 2)));
//        System.out.println(Arrays.toString(Programmers.getInstance().dividedNumber(new int[]{1, 6, 3, 4, 2, 5}, 10)));
    }
}
