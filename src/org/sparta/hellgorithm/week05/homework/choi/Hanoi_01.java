package org.sparta.hellgorithm.week05.homework.choi;

// [문제 1].  하노이의 탑을 코드로 구현[시간복잡도 포함], 하향식 분석
public class Hanoi_01 {

    /*
    시간복잡도 O(2^n)
    N개의 원판을 옮기는 횟수를 T(n)이라고 가정.
    T(n) = 2 * T(n - 1) + 1 공비가 2이고 초항이 1인 등비수열의 합이므로
    T(n) = 2^n - 1 이다.
    하향식 분석은 hanoi.png
     */
    public static void hanoi(int n, int now, int dest) {

        if (n > 1) {
            // n-1 개의 원판을 다른 기둥으로 옮기는 작업.
            hanoi(n - 1, now, 6 - (now + dest));
        }

        // 옮기고 싶은 원판 옮기기.
        System.out.println("원판 " + n + "을 기둥 " + now + "에서 기둥 " + dest + "로 이동");

        if (n > 1) {
            //이전에 옮긴 기둥에서 다시 원하는 기둥으로 옮기기.
            hanoi(n - 1, 6 - (now + dest), dest);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 1, 3);
    }
}
