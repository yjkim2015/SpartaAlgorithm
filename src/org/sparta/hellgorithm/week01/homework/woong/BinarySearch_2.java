package org.sparta.hellgorithm.week01.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_2 {
    static int binSearch(int[] a, int n , int key) {

        //초기 인덱스 범위
        //처음 시작인덱스 이므로 0~n-1까지가 범위.
        int pl = 0;
        int pr = n -1;

        //탐색을 하면서 중간값만 비교하여 범위를 반씩 줄여나가면서 값을 찾을때까지 반복.
        do {
            int pc = (pl + pr) / 2;
            print(n,pl,pr,pc,a);
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

    static void print(int n,int pl,int pr,int pc, int[] a){
        System.out.print("\t\t\t\t\t\t\t");
        //자료 위에 화살표 표시
        for(int i=0; i<n; i++){
            if(i==pl)
                System.out.print("<-\t");
            else if(i==pr)
                System.out.print("->\t");
            else if(i==pc)
                System.out.print("+\t");
            else
                System.out.print(" \t");
        }
        System.out.println();

        System.out.print("현재 조회 인덱스: "+pc+"\t\t\t");
        //현재 자료 데이터값 표시.
        for(int i=0; i<n; i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
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

        int idx = Arrays.binarySearch(x,  ky);

        if ( idx == -1 ) {
            System.out.println("그 값의 요소가 없습니다.");
        }
        else if ( idx != -1 ){
            System.out.println(ky + "은[는] x[" + idx + " ]에 있습니다.");
        }

    }
}