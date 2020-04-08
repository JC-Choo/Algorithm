package com.example.cnwlc.algorithm.hacker_rank.day12;

public class Student extends Person {
    private int[] testScores;

    public Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);

        this.testScores = testScores;
    }

    public String calculate() {
        int addScore = 0;
        for(int score : testScores) {
            addScore += score;
        }

        int avgScore = addScore / testScores.length;

        String result;
        if(90 <= avgScore && avgScore <= 100) {
            result = "O";
        } else if (80 <= avgScore && avgScore <= 90) {
            result = "E";
        } else if (70 <= avgScore && avgScore <= 80) {
            result = "A";
        } else if (55 <= avgScore && avgScore <= 70) {
            result = "P";
        } else if (40 <= avgScore && avgScore <= 55) {
            result = "D";
        } else {
            result = "T";
        }

        return result;
    }

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
}