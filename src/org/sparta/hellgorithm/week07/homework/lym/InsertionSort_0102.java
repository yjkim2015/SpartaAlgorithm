package org.sparta.hellgorithm.week07.homework.lym;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class InsertionSort_0102 {
	
	
	//1번문제
    static int[] sort(int[]a, int n) {
    	
    	int arrOriFirst = a[0];
    	int arrFirst = a[0];
  
        for ( int i = 1; i < n; i++ ) {
            int j;
            
            a[0] = a[i];
            int tmp = a[i];
            
          arrFirst = arrFirst < a[0] ? arrFirst : a[0];
            
            for ( j = i; a[j-1] > tmp; j-- ) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
        System.out.println("맨앞의 요소가 가장 작지 않을경우 사라진숫자 a[0] = "+a[0]);
        a[0] = arrOriFirst < arrFirst ? arrOriFirst : arrFirst;
        //a[1] = arrOriFirst > arrFirst ? arrOriFirst : arrFirst;
        return a;
    }

    //2번문제
    static int[] insertionSort(int[] a, int n) {
   	 
    	for(int i = 1; i < n; i++) {
    		int target = a[i];
     
    		// 0 ~ i 사이 이분탐색을 통해 target이 배치 될 위치를 반환
    		int location = binarySearch(a, target, 0, i);
     
     
    		int j = i - 1;
    		while(j >= location) {
    			a[j + 1] = a[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
    			j--;
    		}
     
    		a[location] = target;	
    	}
    	return a;
    }
    
    static int binarySearch(int[] a, int target, int lo, int i) {
    	int mid;
    	while(lo < i) {
    		mid = lo + ((i - lo) / 2);	// 중간 위치
    			
    		if(target < a[mid]) {	// key < a[mid]라면 탐색 상한선을 중간위치로 변경
    			i = mid;
    		}else {				// 그 외엔 하한선을 중간 다음 위치로 변경
    			lo = mid + 1;
    		}
    	}
    	return lo;
    }
    
    public static void main(String[] args) {
    	//맨앞에 요소는 가장 작은 숫자가 들어가야 합니다.
    	//배열을 추가 삭제 list로 하려고했는대 이것까진 아닌거같고 구글에서도 맨앞에 숫자는 가장작은숫자여야한다함
    	//1번문제
        int[] arr = {1,71,89,90,9,21,22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(sort(arr,13)));
        
        //2번문제
        System.out.println("이진탐색정렬");
        int[] arr2 = {77,99,1,71,89,90,9,21,22,5,11,32,120,68,70};
        System.out.println(Arrays.toString(insertionSort(arr2,15)));
    }
}
