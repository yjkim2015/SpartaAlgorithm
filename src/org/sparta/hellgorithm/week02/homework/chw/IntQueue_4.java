package org.sparta.hellgorithm.week02.homework.chw;

public class IntQueue_4 {
    private int max;    // 큐의 용량
    private int front;  // 첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체

    public class EmptyIntQueueException extends  RuntimeException {
        public EmptyIntQueueException() {
            super("큐가 비었습니다.");
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
            super("큐가 가득찼습니다.");
        }
    }

    public IntQueue_4(int capacity) {
        num = front = rear = 0;
        max = capacity;

        try {
            que = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //4-1) peek
    public int peek() {
        if(IsEmpty())
            throw new EmptyIntQueueException();

        return que[rear-1];
    }
    //4-2) indexOf
    //찾는 값이 있을시 인덱스 반환. 없을 시 -1 반환.
    public int indexOf(int data) {

        for(int i = front; i < rear; i++) {
            if(data == que[i])
                return i;
        }

        return -1;
    }
    //4-3) clear
    public void clear() {
        num = 0;
        rear = 0;
        front = 0;
    }

    //4-4) capacity
    public int capacity() {
        return max;
    }

    //4-5) size
    public int size() {
        return num;
    }

    //4-6) IsEmpty
    public boolean IsEmpty() {
        return rear == front;
    }
    //4-7) IsFull
    public boolean IsFull() {
        return rear == max;
    }

    //4-8) dump
    public void dump() {
        //시간복잡도 : O(1)
        System.out.println("큐 출력");
        //시간복잡도 : O(1)
        System.out.println("--------------");

        //시간 복잡도 : O(N)
        for(int i=front; i<rear; i++){
            System.out.println(i-num+1+"번째 데이터 = "+que[i]);
        }
        //시간복잡도 : O(1)
        System.out.println("---------------");
    }
    //시간 복잡도 : O(N+3) => O(N)

    //4-9) enque
    public void enque(int data) {
        if(IsFull())
            throw new OverflowIntQueueException();
        que[rear++] = data;
        num++;
    }

    //4-10) deque
    public int deque() {
        if(IsEmpty())
            throw new EmptyIntQueueException();
        num--;
        return que[front++];
    }

    public static void main(String[] args) {
        IntQueue_4 queue = new IntQueue_4(10);

       // queue.deque();
        for(int i=0; i<10; i++){
            queue.enque(i);
            queue.dump();
        }

        for(int i=0; i<10; i++){
            queue.deque();
            queue.dump();
        }
    }
}
