package org.sparta.hellgorithm.week01.homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class BinarySearch_3_2 {
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

        //이진 탐색 x배열에 ky값을 search return value는 위치 index
        //값 없을시 탐색과정중 없다고 인식 된 (index +1) * -1
        int idx = Arrays.binarySearch(x,  ky);

        //반환 인덱스가 (index + 1) * -1 에서 index지점에 값 추가
        //즉 index = returnIndex * -1 -1
        if ( idx < 0 ) {
            int inputIndex = idx * -1 - 1 ;
            System.out.println("검색한 데이터가 없습니다.");
            System.out.println("추가로 넣으실 데이터의 위치는 " + inputIndex + "입니다.");
        }
        else if ( idx != -1 ){
            System.out.println(ky + "은[는] x[" + idx + " ]에 있습니다.");
        }
    }
}
