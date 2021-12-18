package sparta.hellgorithm.week06.homework.choi;


import java.util.Arrays;


public class BubbleSort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    /*
문제1. 버블 정렬의 각 패스에서 비교, 교환은 처음(왼쪽) 부터 수행해도된다. 그렇게 수정한 프로그램을 작성하라.
문제2. 비교 교환 과정을 자세히 출력하면서 버블 정렬하는 프로그램을 작성하라. 비교하는 두 요소 사이에 교환을 수행하면'+',
 수행하지 않으면 '-'를 출력하고 정렬을 마치면 비교횟수와 교환 횟수를 출력하라.
 */
    static void bubbleSort1(int[] a, int n) {
        int changeCount = 0;
        int compareCount = 0;
        System.out.println("----- 정렬 시작 -----");
        for ( int i = 0; i < n; i++ ) {
            for ( int j = i + 1; j < n; j++) {
                compareCount++;
                if ( a[j - 1] > a[j] ) {
                    changeCount++;
                    System.out.print("+ ");
                    swap(a, j-1, j);
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("----- 정렬 끝 -----");
        System.out.println("비교 횟수 : " + compareCount + " 교환 횟수 : " + changeCount);
    }

// 문제3.
//버블 정렬 메서드 버전2을 문제2처럼 교환 과정을 자세히 출력하는 프로그램으로 수정하라.
    static void bubbleSort2(int[] a, int n) {
        int changeCount = 0;
        int compareCount = 0;
        System.out.println("----- 정렬 시작 -----");
        for (int i = 0; i < n - 1; i++) {
            int exg = 0;
            for (int j = n - 1; j > i; j--) {
                compareCount++;
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    System.out.print("+ ");
                    changeCount++;
                    exg++;
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
            if (exg == 0) break;
        }
        System.out.println("----- 정렬 끝 -----");
        System.out.println("비교 횟수 : " + compareCount + " 교환 횟수 : " + changeCount);
    }

    /*
    ##### 문제 4. 버블정렬 3메소드도 교환 과정을 자세히 출력하는 프로그램을 작성하라.
     */
    static void bubbleSort3(int[]a, int n) {
        int changeCount = 0;
        int compareCount = 0;
        System.out.println("----- 정렬 시작 -----");
        int k = 0;
        while ( k < n-1 ) {
            int last = n-1;
            for ( int j = n-1; j > k; j-- ) {
                compareCount++;
                if ( a[j-1] > a[j] ) {
                    swap(a, j-1, j);
                    System.out.print("+ ");
                    changeCount++;
                    last = j;
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
            k = last;
        }
        System.out.println("----- 정렬 끝 -----");
        System.out.println("비교 횟수 : " + compareCount + " 교환 횟수 : " + changeCount);
    }

    //문제 5. 양방향 버블정렬[칵테일 정렬, 세이커정렬] 을 수행하는 프로그램을 작성하라.
    static void CocktailShakerSort(int[] a, int n) {
        boolean swap = true;
        int i = 0;
        int j = n -1;
        while (i < j && swap) {
            swap = false;
            for (int k = i; k < j; k++) {
                if(a[k] > a[k+1]) {
                    swap(a,k+1,k);
                }
            }
            j--;
            if (swap) {
                swap = false;
                for (int k = j; k > i; k--) {
                    if ( a[k-1] > a[k] ) {
                        swap(a, k-1, k);
                        swap = true;
                    }
                }
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] x = {1,3,4,9,6,7,8};
        CocktailShakerSort(x, 7);
        Integer[] boxingNumbers = Arrays.stream(x).boxed().toArray(Integer[]::new);

        StringBuilder numberSB = new StringBuilder();

        for (int i = 0; i < boxingNumbers.length; i++) {
            numberSB.append("%d ");
        }
        System.out.printf(numberSB + "\n", boxingNumbers);
    }
}
