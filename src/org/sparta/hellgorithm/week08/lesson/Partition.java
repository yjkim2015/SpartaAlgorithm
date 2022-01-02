package org.sparta.hellgorithm.week08.lesson;

public class Partition {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void partition(int[] a, int n) {
        int pl = 0; // 왼쪽 커서
        int pr = n-1; // 오른쪽 커서
        int x = a[n / 2]; //피벗 (가운데 위치의 값)

        do {
            while( a[pl] < x ) pl++; // a[pl] >= x 가 성립하는 요소를 찾을 때 까지 pl을 오른쪽으로 스캔한다.
            while( a[pr] > x) pr--; // a[pr] <= x가 성립하는 요소를 찾을 때 까지 pr을 왼쪽으로 스캔한다.

            if ( pl <= pr ) {
                swap(a, pl++, pr--); // pl과 pr과 같은 부분을 1회는 교회해도 무방하다 매번 검사할바엔
            }

        } while (pl <= pr);

        System.out.println("피벗의 값은 " + x + " 입니다");

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl -1; i++ ) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        if ( pl > pr + 1 ) {
            System.out.println("피벗과 일치하는  그룹");
            for (int i = pr + 1; i <= pl - 1; i++ ) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i < n; i++ ) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {1,8,7,4,5,2,6,3,9};
        int n = 9;
        partition(a, n);
    }
}
