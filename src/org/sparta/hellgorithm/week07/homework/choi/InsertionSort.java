package week07.homework.choi;

import java.util.Arrays;

public class InsertionSort {

    static int[] sort(int[]a, int n) {
        for ( int i = 1; i < n; i++ ) {
            int j;
            int tmp = a[i];
            for ( j = i; j > 0 && a[j-1] > tmp; j-- ) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }

        return a;
    }

    /*
    문제 1. 단순 삽입 정렬에서 배열의 첫 번째 요소(a[0])부터 데이터를 저장하지 않고, a[1]부터 데이터를
    저장하면 a[0]을 보초로 하여 삽입을 마치는 조건을 줄일 수 있다.
     */
    static int[] insertion(int a[], int n) {
        for (int i = 2; i < n; i++) {
            int tmp = a[0] = a[i];
            int j;
            for (j = i; a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            if (j > 0)
                a[j] = tmp;
        }
        return a;
}

/*
    문제2. 단순 삽입 정렬은 배열의 요솟수가 많아지면 많아질수록 요소
    삽입에 필요한 대교, 대입 비용이 무시할 수 없을 정도로 커진다.
    이때 배열에서 이미 정렬된 부분은 이진 검색을 사요할 수 있기 때문에
    삽입할 위치를 더 빨리 찾을 수 있다. 이진 검색을 사용하여 프로그램을 수정하라.
 */
    static int[] binaryInsertion(int a[], int n)
    {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int left = 0;
            int right = i - 1;
            int middle, index;

            do {
                middle = (left + right) / 2;
                if (a[middle] == value) {
                    break;
                } else if (a[middle] < value) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } while (left <= right);

            index = (left <= right) ? middle + 1 : right + 1;

            for (int j = i; j > index; j--) {
                a[j] = a[j - 1];
            }
            a[index] = value;
        }

        return a;
    }

    /*
    문제3. 셸정렬을 위의 수열의 법칙을 이용하여 수정하라.
     */

    static int getH(int n) {
        int h = 1;
        while (h < n / 9) {
            h *= 3 * h + 1;
        }
        return h;
    }
    public static int[] shellSort(int a[], int n) {

        int h = getH(n);
        for(; h > 0; h /=3) {
            for(int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for(j = i - h; j >= 0 && a[j] > tmp; j-=h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {22,5,11,32,120,68,70};
        int[] arr2 = {0, 22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(sort(arr,7)));

        //문제 1 결과
        System.out.println(Arrays.toString(insertion(arr2,8)));
        //문제 2 결과
        System.out.println(Arrays.toString(binaryInsertion(arr,7)));
        //문제 3 결과
        System.out.println(Arrays.toString(shellSort(arr,7)));
    }
}
