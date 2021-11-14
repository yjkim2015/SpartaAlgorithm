package org.sparta.hellgorithm.week02.homework.chw;


import org.sparta.hellgorithm.week02.homework.chw.CustomException.EmptyStackException;
import org.sparta.hellgorithm.week02.homework.chw.CustomException.OverflowStackException;

public class GStack_3<E> {
    private int max;    //스택 용량
    private int ptr;    // 스택 포인터  : 스택에 쌓여있는 데이터 수를 나타내는 필드 즉, 배열 stk의 요솟수
    private E[] stk;  // 스택 본체 배열


    //2-1) push : 스택에 데이터를 푸시하는 메서드
    public void push(E data) {

        if(IsFull()) {
            //시간 복잡도 : O(1)
            throw new OverflowStackException();
        }

        //시간복잡도 : O(1)
        stk[ptr++] = data;
    }

    //총 시간복잡도 = O(1) 총 공간복잡도 = O(E크기)

    //2-2) pop : 스탭의 꼭대기에서 데이터를 제거하고 그 값을 반환하는 메서드
    public E pop() {

        //시간 복잡도 : O(1)
        if(IsEmpty())
            //시간 복잡도 : O(1)
            throw new EmptyStackException();

        //시간복잡도 : O(1)
        return stk[--ptr];
    }
    //총 시간복잡도 : O(1 + 1) = O(2)

    // 2-3) peek : 스택의 꼭데기에 있는 데이터를 몰래 엿보는 메서드
    public E peek() {
        //시간 복잡도 : O(1)
        if(IsEmpty())
            //시간 복잡도 : O(1)
            throw new EmptyStackException();

        //시간복잡도 : O(1)
        return stk[ptr-1];
    }
    //총 시간복잡도 : O(1 + 1 ) = O(2) 총 공간복잡도 = X

    // 2-4) indexOf : 스택 본체의 배열 stk에 x와 같은 값의 데이터가 포함되어 있는지, 포함되어 있다면 배열의 어디에 들어 있는지를 조사하는 메서드
    // 있을시 index 반환 없을시 -1 반환.
    public int indexOf(E data) {

        //시간 복잡도 : O(ptr)
        for(int i = 0; i < ptr; i++) {
            if(stk[i] == data)
                return i;
        }
        return -1;
    }
    // 총 시간복잡도 = O(ptr) 총 공간복잡도 = X

    // 2-5) clear : 스택에 쌓여있는 모든 데이터를 반환하는 메서드
    public void clear() {
        //시간복잡도 : O(1)
        this.ptr = 0;
    }
    // 총 시간복잡도 = O(1) 총 공간복잡도 = X

    // 2-6) capacity : 스택의 용량을 반환하는 메서드
    public int capacity() {
        //시간복잡도 : O(1)
        return max;
    }
    //  총 시간복잡도 = O(1) 총 공간복잡도 = X

    // 2-7) size : 현재 스택에 쌓여있는 데이터 수를 반환 하는 메서드
    public int size(){
        //시간복잡도 : O(1)
        return ptr;
    }
    //총 시간복잡도 = O(1) 총 공간복잡도 = X

    // 2-8) IsEmpty : 스택이 비어있는지 확인하는 메서드
    public boolean IsEmpty() {
        //시간복잡도 : O(1)
        return ptr == 0;
    }
    //총 시간복잡도 = O(1) 총 공간복잡도 = X

    // 2-9) IsFull : 스택이 가득 찼는지 검사하는 메서드
    public boolean IsFull() {
        //시간복잡도 : O(1)
        return ptr == max;
    }
    //총 시간복잡도 = O(1) 총 공간복잡도 = X

    // 2-10) dump : 스택 안에 모든 데이터를 표시하는 메서드
    public void dump() {
        //시간복잡도 : O(1)
        System.out.println("스택 출력");
        //시간복잡도 : O(1)
        System.out.println("--------------");

        //시간복잡도 : O(N) 공간복잡도 O(4)
        for(int i = 0; i < ptr; i++) {
            System.out.println(i+"번째 데이터: "+stk[i]);
        }
        //시간복잡도 : O(1)
        System.out.println("---------------");
    }
    //총 시간복잡도 = O(N+3) => O(N) 총 공간복잡도 = O(4)

    public GStack_3(int capacity) {
        //공간 복잡도 = O(N) //변수크기 N
        ptr = 0;
        //공간 복잡도 = O(N)
        max = capacity;
        try {
            //공간 복잡도 = O(max * E_Size)
            stk = (E[]) new Object[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }

    }
    //총 시간복잡도 = O(ptr) 총 공간복잡도 = O(E_size * max + 2*N) = O(N)

    public void main(String[] args) {
        GStack_3 stack = new GStack_3<E>(10);
        //O(N)
        stack.dump();

        //시간복잡도 O(N)
        for(int i = 1; i < 10; i++){
            stack.push('a'+i);
            stack.dump();
        }

        //시간복잡도 O(N)
        for(int i=1; i < 10; i++) {
            stack.pop();
            stack.dump();
        }
    }
    //총 시간복잡도 O(3N) == O(N)
}
