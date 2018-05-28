package com.example.cnwlc.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        programmers();
    }

    private void programmers() {
        System.out.println(Programmers.getInstance().getMiddelChar("power"));

        System.out.println(Arrays.toString(Programmers.getInstance().getMaxAndMin(3, 12)));

        System.out.println(Programmers.getInstance().getStrToInt("-1234"));

        System.out.println(Programmers.getInstance().fibonacci(3));

        String[] names = {"Queen", "Tod","Kim"};
        System.out.println(Programmers.getInstance().findKim(names));

        System.out.println(Programmers.getInstance().sumDivisor(12));

        int[] array = {5, 9, 7, 10};
        System.out.println( Arrays.toString(Programmers.getInstance().divisible(array, 5)));

        String str = "1 2 3 4";
        System.out.println("최대값과 최소값은?" + Programmers.getInstance().getMinMaxString(str));

        int month = 1, day = 1;
        System.out.println("1월 1일은 " + Programmers.getInstance().get2016(1, 1)+"DAY 입니다.");
        System.out.println("1월 31일은 " + Programmers.getInstance().get2016(1, 31)+"DAY 입니다.");
        System.out.println("2월 1일은 " + Programmers.getInstance().get2016(2, 1)+"DAY 입니다.");
        System.out.println("2월 29일은 " + Programmers.getInstance().get2016(2, 29)+"DAY 입니다.");
        System.out.println("3월 1일은 " + Programmers.getInstance().get2016(3, 1)+"DAY 입니다.");
        System.out.println("3월 31일은 " + Programmers.getInstance().get2016(3, 31)+"DAY 입니다.");
        System.out.println("5월 24일은 " + Programmers.getInstance().get2016(5, 24)+"DAY 입니다.");
    }
}
