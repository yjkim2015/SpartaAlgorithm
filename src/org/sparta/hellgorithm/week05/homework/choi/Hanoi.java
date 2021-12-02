package org.sparta.hellgorithm.week05.homework.choi;

// [문제 1].  하노이의 탑을 코드로 구현[시간복잡도 포함], 하향식 분석
public class Hanoi {

    public static void hanoi(int n, int now, int dest) {

        if (n > 1) {
            hanoi(n - 1, now, 6 - (now + dest));
        }
        System.out.println("원판 " + n + "을 기둥 " + now + "에서 기둥 " + dest + "로 이동");
        if (n > 1) {
            hanoi(n - 1, 6 - (now + dest), dest);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 1, 3);
    }
}
