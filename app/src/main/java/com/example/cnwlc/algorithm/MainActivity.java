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
        System.out.println("최대값과 최소값은?" + Programmers.getInstance().getMinMaxString("-3 -2 -1 -4"));
        System.out.println("최대값과 최소값은?" + Programmers.getInstance().getMinMaxString("-4 -2 -3 -1"));
    }
}
