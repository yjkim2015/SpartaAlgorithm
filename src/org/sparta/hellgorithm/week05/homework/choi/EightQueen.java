package org.sparta.hellgorithm.week05.homework.choi;

//문제 2. 완전하게 8퀸문제를 해결한 EightQueen 클래스를 작성하라. [시공간복잡도 포함]
public class EightQueen {
    static boolean[] flag = new boolean[8]; //각 행에 퀸을 배치했는지 체크
    static int[] pos = new int[8];  //각 열의 퀸의 위치
    static boolean[] flagRight = new boolean[15]; // 퀸 오른쪽 대각선 배치했는지 체크.
    static boolean[] flagLeft = new boolean[15]; // 퀸 왼쪽 대각선 배치했는지 체크.

    // 각 열의 퀸의 위치를 출력한다.
    static void print() {
        // 시간 복잡도 O(8) 공간복잡도 O(IntSize(4) * 8)
        for ( int i = 0; i < 8; i++ ) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치한다
    static void set(int i) {
        for ( int j = 0; j < 8; j++ ) {
            if ( flag[j] == false && flagRight[i + j] == false && flagLeft[i - j + 7] == false) {   //j행에는 퀸을 아직 배치하지 않았다면
                pos[i] = j;             // 퀸을 j행에 배치
                if ( i == 7 ) {         // 모든 열에 배치한 경우
                    print();
                }
                else {
                    flag[j] = true;
                    flagRight[i + j] = true;
                    flagLeft[i - j + 7] = true;
                    set(i+1);
                    flag[j] = false;
                    flagRight[i + j] = false;
                    flagLeft[i - j + 7] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        set(0);
    }
}
