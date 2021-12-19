package org.sparta.hellgorithm.week06.lesson;

import java.util.Arrays;

public class BubbleSort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort1(int[] a, int n) {
        for ( int i = 0; i < n - 1; i++ ) {
            for ( int j = n - 1; j > i; j-- ) {
                if ( a[j - 1] > a[j] ) {
                    swap(a, j-1, j);
                }
            }
        }
    }

    static void bubleSort2(int[] a, int n) {
        for ( int i = 0; i < n - 1; i++ ) {
            int exchg = 0;
            for ( int j = n - 1; j > i; j-- ) {
                if ( a[j - 1] > a[j] ) {
                    swap(a, j-1, j);
                    exchg++;
                }
            }
            if (exchg == 0) break;
        }
    }

    static void bubbleSort3(int[]a, int n) {
        int k = 0;
        while ( k < n-1 ) {
            int last = n-1;
            System.out.println("k : " + k);

            for ( int j = n-1; j > k; j-- ) {
                if ( a[j-1] > a[j] ) {
                    swap(a, j-1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    public static void main(String[] args) {
        int[] x = {1,3,9,4,7,8,6};
        bubbleSort3(x, 7);
        Integer[] boxingNumbers = Arrays.stream(x).boxed().toArray(Integer[]::new);

        StringBuilder numberSB = new StringBuilder();

        for (int i = 0; i < boxingNumbers.length; i++) {
            numberSB.append("%d ");
        }
        System.out.printf(numberSB + "\n", boxingNumbers);
    }
}

