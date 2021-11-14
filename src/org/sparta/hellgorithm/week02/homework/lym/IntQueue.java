package org.sparta.hellgorithm.week02.homework.lym;

import java.util.logging.Logger;

import org.sparta.hellgorithm.week02.homework.lym.IntStack.EmptyIntStackException;

public class IntQueue {
    private int max;    // 큐의 용량
    private int front;  // 첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체

    
  //빈거
    public class EmptyIntQueueException extends  RuntimeException {
        public EmptyIntQueueException() {
        	Logger LOG = Logger.getGlobal();
        	LOG.warning(" : 에러났자나 이새뀌야 공간에 뭐라도 채워");
        }
    }
    /*
     * 시간복잡도 O(1) -- que의 크기가 커져도 로그는 하나만 찍으니깐
     * 공간복잡도 O(1) -- LOG 하나만 씀
     */

    //든거
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        	Logger LOG = Logger.getGlobal();
        	LOG.warning(" : 에러났자나 이새뀌야 공간좀 비워");
        }
    }
    
    /*
     * 시간복잡도 O(1) -- squek의 크기가 커져도 로그는 하나만 찍으니깐 시간복잡도 : 1
     * 공간복잡도 O(1) -- LOG 하나만 씀 공간복잡도 : 1
     */

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        }
        catch (OutOfMemoryError e) {
        	e.printStackTrace();
            max = 0;
        }
    }

    
    public int enque(int val) {
    	System.out.println("큐 enque 실행 : queue["+rear+"]"+"= "+val);
    	if(rear >= max){
    		throw new OverflowIntQueueException();
    	}else {
    		que[rear++] = val;
    		num++;
    	}
    	
    	return val;
    }
    
    /*
     * 시간복잡도 O(1) -- n과 상관없이 비교후 데이터 넣기 1번 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 val,rear,max,num,que[rear] 총 5개 공간복잡도 : 5
     */
    
    
    
    public int deque() {
    	System.out.println("큐 deque 실행 : queue["+front+"]"+"= "+que[front]);
    	int result;
    	if(front >= rear){
    		throw new EmptyIntQueueException();
    	}else {
    		result = que[front];
    		que[front] = 0;
    		num--;
    		front++;
    	}
    	
    	return result;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 비교후 데이터 빼기 1번 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 rear,num,que[front],front 총 4개 공간복잡도 : 4
     */
    
    
    //큐 현재값 보여주기 메소드
    public void dump() {
    	System.out.println("큐 dump 실행 : 데이터수 :"+num + "  큐의용량 :"+max+"  front : "+front +"  rear: "+rear);
    	System.out.print("#### ");
    	for(int i=front;i<rear;i++) { //stk 배열의 각 값을 출력
    		System.out.print("queue["+i+"]="+que[i]+ "    ");
    	}
    	System.out.println();
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    //큐의 꼭대기에 있는 데이터 표출
    public int peek() { 
    	System.out.println("큐 peek 실행 : peek["+(rear-1)+"]"+"= "+que[(rear-1)]);
        if(front == rear) {
            throw new EmptyIntQueueException();
        }
        return que[rear - 1];
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 마지막 인덱스값 출력 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 rear,que 총 2개 공간복잡도 : 2
     */
    
    
    //큐 본체의 배열에서 x와 같은값을 찾는 메서드
    public int indexOf(int x) {
    	if(front == rear) throw new EmptyIntQueueException();
    	for(int i=front;i<rear;i++) { //배열탐색
    		if(que[i] == x) {//찾는값이 잇을경우
    			System.out.println("큐 indexOf 실행 (찾을값 "+x+") : queue["+i+"]"+"= "+que[i] +" ## return : "+i);
    			return i;
    		}
    	}
    	return -1;// 찾는값이 없을경우
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    
    // 큐를 비움
    public void clear() {
    	System.out.println("큐 clear 실행 ");
    	for(int i=front;i<rear;i++) { //배열탐색
    		que[i] = 0;
    	}
    	front = rear = num = 0;
    }
    /*
     * 시간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     * 공간복잡도 O(n) -- n의 크기만큼 for문 반복 O(n);
     */
    
    
    public int capcity() {// 배열의 크기를 반환.
    	System.out.println("큐 capcity 실행 :"+max);
    	return max;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 max값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 max 1개 사용 공간복잡도 : 1
     */
    
    public int size() {//배열의 포인터를 반환
    	System.out.println("큐 size 실행 :"+num);
    	return num;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 num값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 num 1개 사용 공간복잡도 : 1
     */
    
    
    public boolean isEmpty() {//큐가 비어있는지 확인
    	System.out.println("큐 isEmpty 실행 :"+ (front >= rear));
        return front >= rear;
    }
    /*
     * 시간복잡도 O(1) -- n과 상관없이 true/false값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 true/false,front,rear 3개 사용 공간복잡도 : 3
     */
    
    
    
    public boolean isFull() {// 큐가 가득 찾는지 확인 num으로 비교해야하나 rear로 비교해야하나..
    	System.out.println("큐 isFull 실행 :"+ (rear >= max));
        return rear >= max;
    }
    
    /*
     * 시간복잡도 O(1) -- n과 상관없이 true/false값 return 시간복잡도 : 1
     * 공간복잡도 O(1) -- n과 상관없이 true/false,rear,max 3개 사용 공간복잡도 : 3
     */
    
    public static void main(String[] args) {
		IntQueue queue = new IntQueue(5);
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.dump();
		queue.deque();
		queue.dump();
		queue.deque();
		queue.dump();
		queue.peek();
		queue.enque(4);
		queue.enque(5);
		queue.dump();
		queue.indexOf(6);
		queue.peek();
		queue.dump();
		queue.deque();
		queue.deque();
		queue.deque();
		queue.dump();
		queue.isEmpty();
		queue.isFull();
		
	}
    
    
}
