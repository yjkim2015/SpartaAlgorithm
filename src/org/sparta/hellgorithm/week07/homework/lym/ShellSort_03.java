package org.sparta.hellgorithm.week07.homework.lym;

import java.util.Arrays;

public class ShellSort_03 {
    static int[] sort(int[] a, int n) {
    	int h;
    	
    	for(h=1; h<n/9; h=h*3+1) {
    		//h=1  h는 1부터시작
    		// h<n/9 요솟수 n을 9로 나눈 값이 넘지 않도록
    		//h=h*3+1  1부터시작해서 3배한값에 1을 더하는 수열
    		// 위와 같은상태로 h의 초기값을 정함
    	}
    	
        for (; h > 0; h /= 3 ) { // h값을 3으로 나누어서 반복하여 마지막 h의 값은 1이됨
        	System.out.println(h+" h회전");
        	//기존의 셀정렬의 시간복잡도는 O(n²) 인데 3으로 나누어서 하면 O(n¹+¼) 이됨
            for ( int i = h; i < n; i++ ) {
                int j;
                int tmp = a[i];
                System.out.println(i+" i회전");
                for ( j = i-h; j >= 0 && a[j] > tmp; j-=h ) {
                	System.out.println(j+" j회전");
                    a[j+h]=a[j];
                }
                a[j+h] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int[] arr = {22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(sort(arr,7)));
    }
}
