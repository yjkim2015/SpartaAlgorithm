package org.sparta.hellgorithm.week08.homework.lym;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort_03 {
    static void swap(int[] a, int idx1, int idx2) {
    	try {
			
    		int t = a[idx1];
    		a[idx1] = a[idx2];
    		a[idx2] = t;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
        int x;
        int m =sort(a,pl,(pl+pr)/2,pr);
        x = a[m];
        swap(a,m,(right-1));

        
        //pivot,left ,right 값 정렬
       // if(a[pl] > a[pivot]) swap(a,pl,pivot);
       // if(a[pivot] > a[pr]) swap(a,pivot,pr);
       // if(a[pl] > a[pivot]) swap(a,pl,pivot);
        //if(a[pivot] > a[right-1]) swap(a,pivot,right-1);
        
        pl++;
        pr -= 2;

        
        while( pl <= pr ) {
            while( a[pl] < x ) pl++;
            while( a[pr] > x ) pr--;
            if ( pl <= pr ) {
                swap(a, pl++, pr--);
            }
        }
        
        
        if(pr-left < right-pl) {
        	swap(a,pl,left);
        	swap(a,pr,right);
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
