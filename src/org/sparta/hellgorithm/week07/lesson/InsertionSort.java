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

    // 단순삽입정렬(보초법：배열의 머리요소는 비어있습니다.)
    static int[] insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int tmp = a[0] = a[i];
            int j = i;
            for (; a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            if (j > 0)
                a[j] = tmp;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(insertionSort(arr,7)));
    }
}
