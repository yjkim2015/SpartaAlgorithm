package org.sparta.hellgorithm.week02.lesson;

public class IntStack {
    private int max;    //스택 용량
    private int ptr;    // 스택 포인터  : 스택에 쌓여있는 데이터 수를 나타내는 필드 즉, 배열 stk의 요솟수
    private int[] stk;  // 스택 본체 배열

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowStackExpception extends  RuntimeException {
        public OverflowStackExpception() {}
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}
