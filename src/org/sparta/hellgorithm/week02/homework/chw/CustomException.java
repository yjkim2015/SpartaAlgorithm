package org.sparta.hellgorithm.week02.homework.chw;

public class CustomException {

    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            //시간복잡도 O(1)
            super("스택이 비어 있습니다.");
        }
    }
    //총 시간복잡도 = O(1) 총 공간복잡도 = X

    public static class OverflowStackException extends  RuntimeException {
        public OverflowStackException() {
            //시간복잡도 O(1)
            super("스택이 가득 찼습니다.");
        }
    }
}
