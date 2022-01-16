package org.sparta.hellgorithm.week08.homework.lym;

import java.util.Arrays;

public class QuickSort_02 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = (left+right)/2;

        //pivot,left ,right 값 정렬
        if(a[pl] > a[pivot]) swap(a,pl,pivot);
        if(a[pivot] > a[pr]) swap(a,pivot,pr);
        if(a[pl] > a[pivot]) swap(a,pl,pivot);
        
        if(right - left + 1 <= 3) return; //원소의 갯수가 3이하일경우 정렬 끝 
        int x = a[pivot];

        
        while( pl <= pr ) {
            while( a[pl] < x ) pl++;
            while( a[pr] > x ) pr--;
            if ( pl <= pr ) {
                swap(a, pl++, pr--);
            }
        }
        if ( left < pr ) quickSort(a, left, pr);
        if ( right > pl ) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
    	int a[] = {7,8,4,2,3,1,6,9,5,17,13,11,16};
        int left = 0;
        int right = a.length -1;
        quickSort(a, left, right);
        System.out.println(Arrays.toString(a));
        //3개로 정렬시 4번만에끝냄  
    }
}
