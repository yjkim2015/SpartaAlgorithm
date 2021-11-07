package org.sparta.hellgorithm.week01.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int binSearch(int[] a, int n , int key) {

        String[] str = new String[n];
        int pl = 0;
        int pr = n -1;

        do {
            int pc = (pl + pr) / 2;

            Arrays.fill(str, " ");
            str[pl] = "<-";
            str[pr] = "->";
            str[pc] = "+";
            printFlagsAndNumbers(str, a);

            if ( a[pc] == key ) {
                return pc;
            }
            else if ( a[pc] < key ) {
                pl = pc + 1;
            }
            else if ( a[pc] > key ) {
                pr = pc - 1;
            }
        } while ( pl <= pr );

        return -1;
    }

    static void printFlagsAndNumbers(String[] flags, int[] numbers) {
        if (flags.length != numbers.length) {
            throw new IllegalArgumentException("잘못된 인자값 입니다.");
        }

        int maxNumber = Arrays.stream(numbers)
                .max()
                .getAsInt();

        int spaceLength = String.valueOf(maxNumber).length();

        if (spaceLength < 3) {
            spaceLength = 3;
        }

        Integer[] boxingNumbers = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        StringBuilder flagSB = new StringBuilder();
        StringBuilder numberSB = new StringBuilder();

        for (int i = 0; i < flags.length; i++) {
            flagSB.append("%" + spaceLength + "s");
            numberSB.append("%" + spaceLength + "d");
        }

        System.out.printf(flagSB + "\n", flags);
        System.out.printf(numberSB + "\n", boxingNumbers);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟 수");
        int num = stdIn.nextInt();

        int[] x = new int[num];
        System.out.println("오름차순으로 입력하세요.");
        x[0] = stdIn.nextInt();
        for ( int i = 1; i < num; i++ ) {
            do {
                System.out.println("x[ " + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.println("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);

        if ( idx == -1 ) {
            System.out.println("그 값의 요소가 없습니다.");
        }
        else if ( idx != -1 ){
            System.out.println(ky + "은[는] x[" + idx + "]에 있습니다.");
        }
    }
}
