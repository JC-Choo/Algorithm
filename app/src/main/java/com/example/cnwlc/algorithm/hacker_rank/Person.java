package com.example.cnwlc.algorithm.hacker_rank;

public class Person {
    private int age;

    public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        this.age = initialAge;
        if(age < 0) {
            System.out.println("Age is not valid, setting age to 0.");
            this.age = 0;
        }
    }

    public void amIOld() {
        String result;
        if(age < 13) {
            result = "You are young.";
        } else if(age < 18) {
            result = "You are a teenager.";
        } else {
            result = "You are old.";
        }

        // Write code determining if this person's age is old and print the correct statement:
        System.out.println(result);
    }

    public void yearPasses() {
        // Increment this person's age.
        age = age+1;
    }
}
