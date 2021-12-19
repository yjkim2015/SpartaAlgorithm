package org.sparta.hellgorithm.week07.lesson;

import java.util.Arrays;

public class InsertionSort {

    static int[] sort(int[]a, int n) {
        for ( int i = 1; i < n; i++ ) {
            int j;
            int tmp = a[i];
            for ( j = i; j > 0 && a[j-1] > tmp; j-- ) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(sort(arr,7)));
    }
}
