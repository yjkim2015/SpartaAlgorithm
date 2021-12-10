package org.sparta.hellgorithm.week05.homework.choi;

//문제 2. 완전하게 8퀸문제를 해결한 EightQueen 클래스를 작성하라. [시공간복잡도 포함]
public class EightQueen_02 {
    //공간복잡도 O(boolean 배열(38) + int 배열(4 * 8 = 32))
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

    /*
    i열의 알맞은 위치에 퀸을 배치한다.
    시간복잡도 : O( n * n -2 * n-4 * n-6 ... )!으로 추정.
    처음에 n개의 열 중 하나의 곳에 둘 수 있기에 n
    그 다음 부터는 꼭짓점의 경우 worst케이스 이므로 2가지의 칸을 제외하고 비교 할 수 있다.
    그 뒤의 칸 마다 최소 2개씩 지워 나갈 수 있기때문에 n - 2 형식으로 줄어 든다.

     */
    static void set(int i) {
        for ( int j = 0; j < 8; j++ ) {
            if ( flag[j] == false && flagRight[i + j] == false && flagLeft[i - j + 7] == false) {   //j행에는 퀸을 아직 배치하지 않았다면
                pos[i] = j;             // 퀸을 j행에 배치
                if ( i == 7 ) {         // 모든 열에 배치한 경우
                    print();
                }
                else {
                    flag[j] = true; // 행에 퀸을 배치했다고 체크.
                    flagRight[i + j] = true; // 오른쪽 대각선에 퀸을 배치했다고 체크.
                    flagLeft[i - j + 7] = true; // 완쪽 대각선에 퀸을 배치했다고 체크.
                    set(i+1);
                    flag[j] = false; // 행에 퀸을 배치 할 수 있다고 체크.
                    flagRight[i + j] = false; // 오른쪽 대각선에 퀸을 배치 했다고 체크.
                    flagLeft[i - j + 7] = false; // 왼쪽대각선에 퀸을 배치 했다고 체크.
                }
            }
        }
    }
    public static void main(String[] args) {
        set(0);
    }
}
