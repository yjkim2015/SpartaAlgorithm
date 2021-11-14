package org.sparta.hellgorithm.week02.homework.lym;

import java.util.logging.Logger;

public class GStack<E> {
    private int max;    //스택 용량
    private int ptr;    // 스택 포인터  : 스택에 쌓여있는 데이터 수를 나타내는 필드 즉, 배열 stk의 요솟수
    public E[] stk;  // 스택 본체 배열

    //빈거
    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() {
        	Logger LOG = Logger.getGlobal();
        	LOG.warning(" : 에러났자나 이새뀌야 공간에 뭐라도 채워");
        }
    }
    /*
     * 시간복잡도 O(1) -- stk의 크기가 커져도 로그는 하나만 찍으니깐
     * 공간복잡도 O(1) -- LOG 하나만 씀
     */

    //든거
    public static class OverflowGStackExpception extends  RuntimeException {
        public OverflowGStackExpception() {
        	Logger LOG = Logger.getGlobal();
        	LOG.warning(" : 에러났자나 이새뀌야 공간좀 비워");
        }
    }
    /*
     * 시간복잡도 O(1) -- stk의 크기가 커져도 로그는 하나만 찍으니깐 시간복잡도 : 1
     * 공간복잡도 O(1) -- LOG 하나만 씀 공간복잡도 : 1
     */

    public GStack(int capacity) {
    	System.out.println("스택 생성자 실행 (배열 크기) : "+ capacity);
        ptr = 0;
        max = capacity;
        try {
            stk = (E[])new Object[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }
    /*
     * 시간복잡도 O(1) -- 1번만 로직이돔 시간복잡도 총 : 1
     * 공간복잡도 O(n) -- ptr , max , stk(n배열크기만큼) 공간복잡도 : O(n)+2
     */
    
    
    //스택 푸시 메소드 (배열에 집어넣기)
    public E push(E num) {
    	System.out.println("스택 push 실행 : push["+ptr+"]"+"= "+num);
    	if(ptr < max) { //스택 배열의 용량과 스택 포인터의 용량과 비교
    		// 넣을 공간 있으면 실행
    		stk[ptr] = num;
    		ptr++;
    	}else {
    		//넣을 공간 없으면 에러발생
    		throw new OverflowGStackExpception();
    	}
		return num;
    }
    
    /*
     * 시간복잡도 O(1) -- n과 상관없이 비교후 데이터 넣기 1번 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 num,ptr,max,stk 총 4개 공간복잡도 : 4
     */
    
    
    
    //스택 pop 메소드 (배열에 마지막 요소 삭제)
    public E pop() { //시간복잡도 O(n) , 공간복잡도 O(n)
    	E result;
    	if(ptr <= 0) { //배열의 포인터가 0인지 판단
    		// 넣은게 없으면 실행
    		throw new EmptyGStackException();
    	}else {
    		//넣은게 있으면 실행
    		System.out.println("스택 pop 실행 : pop["+(ptr-1)+"]"+"= "+stk[(ptr-1)]);
    		result = stk[(ptr-1)]; //가장 마지막 배열 값 result 변수에 담기
    		stk[--ptr] = null; // 마지막배열의 값을 0으로 초기화 및 포인터의 값을 -1 
    	}
    	return result;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 비교후 데이터 빼기 1번 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 ptr,stk,result 총 3개 공간복잡도 : 3
     */
    
    
    //스택 현재값 보여주기 메소드
    public void dump() {
    	int i =0;
    	System.out.println("스택 dump 실행 : 현재 포인터(스택의 현재크기) ptr = "+ptr + " 배열 최대사이즈는 "+max);
    	System.out.print("#### ");
    	for(E a:stk) { //stk 배열의 각 값을 출력
    		if(i==ptr) break;
    		System.out.print("stk["+i+++"]="+a+ "    ");
    	}
    	System.out.println();
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    
    
    //스택의 꼭대기에 있는 데이터 표출
    public E peek() { //시간복잡도 O(n) , 공간복잡도 O(n)
    	System.out.println("스택 peek 실행 : peek["+(ptr-1)+"]"+"= "+stk[(ptr-1)]);
        if(ptr <= 0) {
            throw new EmptyGStackException();
        }
        return stk[ptr - 1];
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 마지막 인덱스값 출력 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 stk,ptr 총 2개 공간복잡도 : 2
     */
    
    
    
    //스택 본체의 배열에서 x와 같은값을 찾는 메서드
    public int indexOf(E x) {
    	if(ptr<=0) throw new EmptyGStackException();
    	int result = 0;
    	for(E a:stk) { //배열탐색
    		if(a==x) {//찾는값이 잇을경우
    			System.out.println("스택 indexOf 실행 (찾을값 "+x+") : stk["+result+"]"+"= "+stk[result] +" ## return : "+result);
    			return result;
    		}
    		result ++;
    	}
    	return -1;// 찾는값이 없을경우
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    
    // 스택을 비움
    public void clear() {
    	System.out.println("스택 clear 실행 ");
    	int i = 0;
    	for(E a:stk) { // for문 돌리면서 데이터 0으로 초기화.
    		stk[i] = null;
    		i++;
    	}
        ptr = 0;
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    
    public int capcity() {// 배열의 크기를 반환.
    	System.out.println("스택 capcity 실행 :"+max);
    	return max;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 max값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 max 1개 사용 공간복잡도 : 1
     */
    
    public int size() {//배열의 포인터를 반환
    	System.out.println("스택 size 실행 :"+ptr);
    	return ptr;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 ptr값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 ptr 1개 사용 공간복잡도 : 1
     */
    
    
    public boolean isEmpty() {//스택이 비어있는지 확인
    	System.out.println("스택 isEmpty 실행 :"+ (ptr <= 0));
        return ptr <= 0;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 true/false값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 true/false,ptr 2개 사용 공간복잡도 : 2
     */
    
    
    
    public boolean isFull() {// 스택이 가득 찾는지 확인
    	System.out.println("스택 isFull 실행 :"+ (ptr >= max));
        return ptr >= max;
    }
    
    /*
     * 시간복잡도 O(1) -- n과 상관없이 true/false값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 true/false,ptr,max 3개 사용 공간복잡도 : 3
     */
    
    
    
    public static void main(String[] args) {
    	
		GStack stack = new GStack(5);
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.pop();
		stack.dump();
		stack.peek();
		stack.indexOf("d");
		stack.clear();
		stack.dump();
		stack.capcity();
		stack.size();
		stack.isEmpty();
		stack.isFull();
    	
	}
}
