package org.sparta.hellgorithm.week0304.homework.lym;

import java.util.Scanner;

/*
    팩토리얼을 재귀적으로 구현
 */
public class Factorial {
    static int factorial(int n) {
        if ( n > 0 ) {
            return n * factorial(n-1);
        }
        else {
            return 1;
        }
    }
    
    static int factorial2(int n) {//내가 작성한 팩토리얼
    	int[] arr = new int[n]; //일반 for문이아닌 향상for문으로 하기위한 배열생성
    	int sum = 1; //합계가 들어가는 변수
    	int index = 1; // 일반 for문의 i를 대체할 변수
	      for(int a:arr) { // 향상 for문 도전
	    	 sum *= index; //1* . . . . . n-1 * n 을위한
	    	 System.out.println(sum + "  "+index);
	    	 index++;
	      }
	    return sum;
    }
    

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수를 입력하세요 : ");

        int x = stdIn.nextInt();

        System.out.println(x +"의 팩토리얼은 " + factorial(x)+ "입니다.");
        System.out.println(x +"의 팩토리얼2는 " + factorial2(x)+ "입니다.");
    }
}
