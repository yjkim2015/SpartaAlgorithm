package org.sparta.hellgorithm.week08.lesson;


public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        int first = a[0];
        int middle = a[a.length/2];
        int last = a[a.length-1];




        System.out.printf("%d}\n", a[right]);

        while( pl < pr ) {
            while( a[pl] < x ) pl++;
            while( a[pr] > x ) pr--;
            if ( pl <= pr ) {
                swap(a, pl++, pr--);
            }
        }
        System.out.println("pl : " + pl + " pr : " + pr);
        if ( left < pr ) quickSort(a, left, pr);
        if ( right > pl ) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        int a[] = {5,8,4,2,6,1,3,9,7};
        int left = 0;
        int right = a.length -1;
        quickSort(a, left, right);
    }
}
