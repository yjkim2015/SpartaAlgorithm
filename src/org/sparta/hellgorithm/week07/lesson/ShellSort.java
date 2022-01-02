package org.sparta.hellgorithm.week07.lesson;

import java.util.Arrays;

public class ShellSort {
    static int[] sort(int[] a, int n) {

        for ( int h = n / 2; h > 0; h /= 2 ) {
            System.out.println("h : " + h);
            for ( int i = h; i < n; i++ ) {
                int j;
                int tmp = a[i];
                System.out.println("i : "+ i);
                System.out.println("a[j] : " + a[i-h] + " tmp : " + tmp);
                for ( j = i-h; j >= 0 && a[j] > tmp; j-=h ) {
                    System.out.println("j : " + j);
                    a[j+h]=a[j];
                }
                a[j+h] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int[] arr = {22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(sort(arr,7)));
    }
}
