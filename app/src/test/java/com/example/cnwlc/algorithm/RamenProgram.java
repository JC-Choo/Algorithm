package com.example.cnwlc.algorithm;

import com.example.cnwlc.algorithm.coding_dictionary.RamenCook;

import org.junit.Test;

public class RamenProgram {
    @Test
    public void main() {
        try {
//            RamenCook ramenCook = new RamenCook(Integer.parseInt(args[0]));
            RamenCook ramenCook = new RamenCook(10);
            new Thread(ramenCook, "A").start();
            new Thread(ramenCook, "B").start();
            new Thread(ramenCook, "C").start();
            new Thread(ramenCook, "D").start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

