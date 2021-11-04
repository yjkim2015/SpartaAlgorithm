package org.sparta.hellgorithm.week01.lesson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    static int binSearch(int[] a, int n , int key) {
        int pl = 0;
        int pr = n -1;

        do {
            int pc = (pl + pr) / 2;
            System.out.println("<-"+pl+" +"+pc+" ->"+pr); 
            // 인덱스 pc + 
            // 검색시작값 pl <- 
            // 끝값 pr 출력 ->
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

    public static void main(String[] args) {
    	/*
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
            System.out.println(ky + "은[는] x[" + idx + " ]에 있습니다.");
        }
        
        */
        // 3-1 문제
       System.out.println("1부터 x 까지 넣을 숫자를 입력하세요 : x값 숫자 입력");
       Scanner scn = new Scanner(System.in);
       int inputNum = scn.nextInt();
       int[] list = new int[inputNum];
       for(int i=0;i<inputNum;i++) {
    	   list[i] = i+1;
       }
       System.out.println("찾을 숫자를 입력해주세요");
       int findNum = scn.nextInt();
       int index = Arrays.binarySearch(list, findNum);
       if(index >-1) {
    	   System.out.println("list["+index+"] 값 존재 " + list[index]);
       }else {
    	   System.out.println("삽입포인트값 : "+index + "   배열의 ["+Math.abs(index)+"] 인덱스에 넣으면된다");
       }
       
    }
}
