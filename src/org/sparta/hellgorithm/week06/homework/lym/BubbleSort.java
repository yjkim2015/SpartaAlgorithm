package org.sparta.hellgorithm.week06.homework.lym;

import java.util.Arrays;

public class BubbleSort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //문제 1번 2번
    //뒤에서 앞으로 검사인 bubbleSort1 을
    // j--를 ++로 변경하고 -1을 +1로 변경하면서 앞에서 검사 시작
    static void bubbleSort1(int[] a, int n) {
    	int sumPlus = 0;
    	int sumMinus = 0;
    	int sum = 0;
    	
        for ( int i = 0; i < n - 1; i++ ) {
        	System.out.println("패스 "+ (i+1)+ "회");
            for ( int j = 0; j < n - 1 - i; j++ ) {
            	if(a[j] > a[j + 1]) {
            		System.out.println("교환수행:(+)  요소1:("+ a[j] + ")  요소2:(" + a[j+1] +")");
            		sumPlus++;
                    swap(a, j, j+1);
                }else {
                	System.out.println("교환수행:(-)  요소1:("+ a[j] + ")  요소2:(" + a[j+1] +")");
                	sumMinus++;
                }
            	sum++;
            	System.out.println(Arrays.toString(a));
            }
        }
        System.out.println("패스횟수:("+n+")  비교횟수:("+sum+")  교환횟수:("+sumPlus+")");
    }

    //문제 3번
    static void bubleSort2(int[] a, int n) {
    	int sumPlus = 0;
    	int sumMinus = 0;
    	int sum = 0;
    	
        for ( int i = 0; i < n - 1; i++ ) {
        	System.out.println("패스 "+ (i+1)+ "회");
            int exchg = 0;
            for ( int j = n - 1; j > i; j-- ) {
                if ( a[j - 1] > a[j] ) {
                	System.out.println("교환수행:(+)  요소1:("+ a[j-1] + ")  요소2:(" + a[j] +")");
            		sumPlus++;
                    swap(a, j-1, j);
                    exchg++;
                }else {
                	System.out.println("교환수행:(-)  요소1:("+ a[j-1] + ")  요소2:(" + a[j] +")");
                	sumMinus++;
                }
            	sum++;
            	System.out.println(Arrays.toString(a));
            }
            if (exchg == 0) break;
        }
        System.out.println("패스횟수:("+n+")  비교횟수:("+sum+")  교환횟수:("+sumPlus+")");
    }

    //문제 4번
    static void bubbleSort3(int[]a, int n) {
    	int sumPlus = 0;
    	int sumMinus = 0;
    	int sum = 0;
        int k = 0;
        
        
        while ( k < n-1 ) {
        	System.out.println("패스 "+ (k)+ "회");
            int last = n-1;
            for ( int j = n-1; j > k; j-- ) {
                if ( a[j-1] > a[j] ) {
                	System.out.println("교환수행:(+)  요소1:("+ a[j-1] + ")  요소2:(" + a[j] +")");
            		sumPlus++;
                    swap(a, j-1, j);
                    last = j;
                }else {
                	System.out.println("교환수행:(-)  요소1:("+ a[j-1] + ")  요소2:(" + a[j] +")");
                	sumMinus++;
                }
            	sum++;
            	System.out.println(Arrays.toString(a));
            }
            k = last;
        }
        System.out.println("패스횟수:("+n+")  비교횟수:("+sum+")  교환횟수:("+sumPlus+")");
    }

    
    //문제 5번
    static void bubbleSort4(int[]a, int n) {
    	int sumRight = 0;
    	int sumLeft = 0;
    	int sum = 0;
    	
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            int j = 0;
            for (j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                	System.out.println("교환수행:(left)  요소1:("+ a[j-1] + ")  요소2:(" + a[j] +")");
                	sumLeft++;
                    swap(a, j - 1, j);
                    last = j;
                    System.out.println(Arrays.toString(a));
                }
            }
            left = last;

            for (j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                	System.out.println("교환수행:(right)  요소1:("+ a[j] + ")  요소2:(" + a[j+1] +")");
                	sumRight++;
                    swap(a, j, j + 1);
                    last = j;
                    System.out.println(Arrays.toString(a));
                }
            }
            right = last; 
        }
        System.out.println("패스횟수:("+n+")  right교환횟수:("+sumRight+")  left교환횟수:("+sumLeft+")");
    }
    
    public static void main(String[] args) {
    	/*
        int[] x = {1,3,4,9,6,7,8};
        bubbleSort3(x, 7);
        Integer[] boxingNumbers = Arrays.stream(x).boxed().toArray(Integer[]::new);

        StringBuilder numberSB = new StringBuilder();

        for (int i = 0; i < boxingNumbers.length; i++) {
            numberSB.append("%d ");
        }
        System.out.printf(numberSB + "\n", boxingNumbers);
        */
        int[] x = {1,3,4,9,6,7,8};
        int[] x2 = {1,3,4,9,6,7,8};
        int[] x3 = {1,3,4,9,6,7,8};
        int[] x4 = {9,1,3,4,6,7,8};
        //int[] x3 = {3,9,7,4,5,6,8};
        bubbleSort1(x, 7);  //문제 1번 2번
        System.out.println();
        System.out.println();
        System.out.println();
        bubleSort2(x2, 7); // 문제 3번
        System.out.println();
        System.out.println();
        System.out.println();
        bubbleSort3(x3, 7); // 문제 4번
        System.out.println();
        System.out.println();
        System.out.println();
        bubbleSort4(x4, 7); // 문제 5번
        
    	
    }
}

