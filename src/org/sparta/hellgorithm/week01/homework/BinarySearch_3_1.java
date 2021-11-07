package org.sparta.hellgorithm.week01.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_3_1 {
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

        //Arrays.binarySearch를 사용하여 이진탐색 인자값은 (배열, 찾는 key)
        int idx = Arrays.binarySearch(x,  ky);

        //Arrays.binarySearch를 사용하여 데이터가 없을시 (인덱스 + 1) * -1 리턴.
        //즉 없을시 음수 값이므로 음수 일 시 값의 요소가 없음.
        if ( idx < 0 ) {
            System.out.println("그 값의 요소가 없습니다.");
        }
        else if ( idx != -1 ){
            System.out.println(ky + "은[는] x[" + idx + " ]에 있습니다.");
        }
    }
}
