package org.sparta.hellgorithm.week0304.homework.lym;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.sparta.hellgorithm.week02.homework.lym.IntStack;

public class Recur {
    //재귀 함수
    static void recur(int n) {
        if ( n > 0 ) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }
    
    static void recur2(int n) {
    	if ( n > 0 ) {
    		recur2(n-2);
    		System.out.println(n);
    		recur2(n-1);
    	}
    }
    
    static List<Integer> stack(int n) {
    	
    	IntStack stack = new IntStack(n);
    	List<Integer> result = new ArrayList<Integer>();//출력 결과를 넣을 배열을 만든다.
    	
    	while(true) {//break문을 만날떄까지 반복
    		if(n>0) {
    			stack.push(n);
    			n -=1;
    			continue;
    		}// 스택에 n-1 씩 다 집어넣는다,
    		
    		if(stack.isEmpty() != true) {
    			n = stack.pop(); //스택에서 하나씩 뺸다.
    			result.add(n);
    			System.out.println("############### stack 출력#### : " + n);
    			n= n-2; //n의 변수를 -2로 하여 0이하일경우 출력이 x이니 pop 만하고
    			//양수일경우 재귀함수일경운 또다시 호출해아하니 push로 다시 넣는다
    			continue;
    		}
    		break;
    	}
    	return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("정수를 입력하세요:");
        int x = stdIn.nextInt();
        //recur(x);
        //recur2(x); // 상향식.jpg , 하향식.jpg 파일참조
        System.out.println(stack(x).toString());
        
    }
}

