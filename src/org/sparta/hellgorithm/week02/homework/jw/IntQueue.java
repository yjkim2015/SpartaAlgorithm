package org.sparta.hellgorithm.week02.homework.jw;

import org.sparta.hellgorithm.week02.homework.jw.customexception.EmptyIntQueueException;
import org.sparta.hellgorithm.week02.homework.jw.customexception.OverflowIntQueueException;

import java.util.Arrays;

public class IntQueue {

    private int max;    // 큐의 용량
    private int front;  // 첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체

    /**
     * 큐 배열에 마지막 값 반환 (큐 내부 요소 및 포인터 변경 사항 없음)
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyIntQueueException("큐가 비어있습니다.");
        }
        return que[front];
    }

    /**
     * 큐 배열에 요소 위치 찾기
     * @param element
     * @return int
     * @return -1 : 찾기 실패
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     */
    public int indexOf(int element) {
        int idx = 0;

        if (isEmpty()) {
            throw new EmptyIntQueueException("큐가 비어있습니다.");
        }

        for (int e : que) {
            if (e == element) {
                return idx;
            }

            idx++;
        }

        return -1;
    }

    /**
     * 큐 배열 초기화
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public void clear() {
        que = new int[max];
        num = front = rear = 0;
    }

    /**
     * 큐 배열의 용량 반환
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public int capacity() {
        return max;
    }

    /**
     * 큐 배열의 데이터 수 반환
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public int size() {
        return num;
    }

    /**
     * 큐 배열이 비어있는지 확인
     * @return boolean
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public boolean isEmpty() {
        if (num <= 0) {
            return true;
        }

        return false;
    }

    /**
     * 큐 배열이 가득 차있는지 확인
     * @return boolean
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(1)
     */
    public boolean isFull() {
        if (num == max) {
            return true;
        }

        return false;
    }

    /**
     * 큐 배열 안에 모든 데이터 표시
     * @return String
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     */
    public String dump() {
        if (isEmpty()) {
            throw new EmptyIntQueueException("큐가 비어있습니다.");
        }

        return Arrays.toString(que);
    }

    /**
     * 큐 배열내 요소 추가
     * @param element
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public void enque(int element) {
        if (num >= max) {
            throw new OverflowIntQueueException("포인터값이 용량을 벗어났습니다.");
        }

        que[rear] = element;
        rear = getIncIndex(rear);
        num++;
    }

    /**
     * 큐 배열내 요소 삭제
     * @return int
     * 시간 복잡도 O(1)
     * 공간 복잡도 O(n)
     */
    public int deque() {
        if (num <= 0) {
            throw new EmptyIntQueueException("큐가 비어있습니다.");
        }

        int element = que[front];
        que[front] = 0;
        front = getIncIndex(front);
        num--;

        return element;
    }

    /**
     * 큐 배열 사이즈 내에서 index 1씩 증가
     * @param value
     * @return int
     */
    private int getIncIndex(int value) {
        int idx = value + 1;

        if (idx == max) {
            return 0;
        }

        return idx;
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;

        max = capacity;

        try {
            que = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}
