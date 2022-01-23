package org.sparta.hellgorithm.week08.homework.lym;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort_03 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    static int sort(int[] a, int pl , int pivot,int pr) {
    	if(a[pl] > a[pivot]) swap(a,pl,pivot);
        if(a[pivot] > a[pr]) swap(a,pivot,pr);
        if(a[pl] > a[pivot]) swap(a,pl,pivot);
        return pivot;
    }
    
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = (left+right)/2;

        if(right - left + 1 <= 3) return; //원소의 갯수가 3이하일경우 정렬 끝 
        
        System.out.println("배열 : "+Arrays.toString(a));
        
        int m = sort(a,pl,(pl+pr)/2,pr);
        int x = a[m];
        
        //swap(a,m,(right-1));
        System.out.println(x);
        
        while( pl <= pr ) {
            while( a[pl] < x ) pl++;
            while( a[pr] > x ) pr--;
            if ( pl <= pr ) {
                swap(a, pl++, pr--);
            }
        }
        
        /*
        if(pr-right < left-pl) {
        	swap(a,pl,left);
        	swap(a,pr,right);
        }
        */
        
        
        if ( left < pr ) quickSort(a, left, pr); //왼쪽 정렬하기
        if ( right > pl ) quickSort(a, pl, right); // 오른쪽 정렬하기
    }

    public static void main(String[] args) {
        int a[] = {7,8,4,2,3,1,6,9,5,17,13,11,16};
        int left = 0;
        int right = a.length -1;
        quickSort(a, left, right);
        System.out.println(Arrays.toString(a));
    }
}
