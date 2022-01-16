package org.sparta.hellgorithm.week08.homework.lym;

import java.util.Arrays;

import org.sparta.hellgorithm.week02.homework.lym.IntStack;

public class IntStackQuickSort_01 {
	static IntStack leftStack;
	static IntStack rightStack;
	
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
    	
        while(!rightStack.isEmpty()) { 
        	//right 스택이 0이 될때까지.. left 스택이랑 한쌍이라 비엇으면 더이상 정렬할것이 없다.
        	
        	left = leftStack.pop();
        	right = rightStack.pop();
        	
        	int pl = left;
        	int pr = right;
        	int pivot = a[(pl + pr) / 2]; //가운데값 넣기
        	
        	while(pl <= pr) {// left 포인터와 right 포인터가 만나면 멈춤
        		while(a[pl]<pivot) { //left 탐색
        			pl++;
        		}
        		while(a[pr]>pivot) { //right 탐색
        			pr--;
        		}
        		if(pl<=pr) { //left 에서 멈춘 포인터와 right에서 멈춘 포인터 비교
        			swap(a, pl++, pr--); // a[pl] 과 a[pr] 서로교체
        		}
        	}
        	
        	if(pl-1 > left) {
        		leftStack.push(left);   // left 그룹애들 index넣음
        		rightStack.push(pl-1); 
        	}
        	
        	if(pl < right) {
        		leftStack.push(pl);  // right 그룹애들 index넣음
        		rightStack.push(right);
        	}
        }

    }
    
    public static void main(String[] args) {
        int a[] = {5,8,4,2,6,1,3,9,7}; //배열
        
    	leftStack = new IntStack(9);// left 포인터를 담을 놈
    	rightStack = new IntStack(9);// right 포인터를 담을놈
        
        int left = 0;
        int right = a.length -1;
        
        leftStack.push(left); //left 포인터 초기화 담음
        rightStack.push(right); // right 포인터 초기화 담음
        
        quickSort(a, left, right);
        System.out.println(Arrays.toString(a));
    }
}

	
