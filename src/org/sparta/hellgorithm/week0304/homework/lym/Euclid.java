package org.sparta.hellgorithm.week0304.homework.lym;

public class Euclid {

	
	public static int mod(int a,int b) {
		int c = a % b; //a와 b의 나머지를 구한다.
		System.out.println("a:"+a +"  b:"+b+"  c:"+c);
		if(c <=0) {
			return b;// 나머지가 0이면 작은수인 b를리턴
		}else {
			return mod(b,c);// 나머지가 0이 아니면 재귀함수로 다시호출
		}
	}
	public static void main(String[] args) {
		
		
		System.out.println(mod(25,5));
	}

}
