package org.sparta.hellgorithm.week0304.homework.choi;

public class Factorial_03 {

    public static int factorial(int n) {

        int answer = 1;
        for(int i = 2; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
