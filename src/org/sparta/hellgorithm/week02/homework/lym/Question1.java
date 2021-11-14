package org.sparta.hellgorithm.week02.homework.lym;

public class Question1 {

	public static void m1(int a) {
		m2(++a);
		System.out.printf("m1():%d", a);	
	}
	
	public static void m2(int a) {    
		m3(++a);    
		System.out.printf("m2():%d", a);  
	}    
	
	public static void m3(int a) {
		++a;
		System.out.printf("m3():%d", a);  
	}    
	
	public static void main(String[] args) {    
		int a = 20;    
		m1(a);    
		System.out.printf("main():%d", a);  
	}
	
	//스택 구조
	/*
		m3() : a=23       
		m2() : a=22
		m1() : a=21
		main() : a=20
		
		이렇게 메모리에 적재되며
		후입선출 이기떄문에
		가장 나중에 넣은데이터 (rear)쪽 데이터가
		가장 먼저 나간다.
	 */

}
