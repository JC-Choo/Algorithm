package com.example.cnwlc.algorithm.test;

public class CallAccessController {
    TestAccessController tac = new TestAccessController();
    public void main() {
        tac.test01 = 30;
        tac.print01();
        tac.test02 = 40;
        tac.print02();
        tac.test03 = 50;
        tac.print03();

        tac.toString();
    }
}
