package org.sparta.hellgorithm.week05.homework.lym;

//각 행, 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열
public class EightQueen_02 {
    static boolean[] flag = new boolean[8]; //각 행에 퀸을 배치했는지 체크
    static int[] pos = new int[8];  //각 열의 퀸의 위치
    
	static boolean[] upFlag= new boolean[15]; //오른족 위에 대각선 을 체크
	static boolean[] downFlag= new boolean[15]; // 오른쪽 아래 대각선을 체크
	//배열은 0부터 체크하고 들어가기때문에 왼쪽은 상관없이 오른쪽만 계산한다
	static int sum = 0;

    // 각 열의 퀸의 위치를 출력한다.
    static void print(int a,int b) {
        for ( int i = 0; i < 8; i++ ) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.print("     i  j = "+a +" "+b);
        System.out.println();
        sum++;
    }

    // i열의 알맞은 위치에 퀸을 배치한다
    static void set(int i) {
        for ( int j = 0; j < 8; j++ ) {
            if ( flag[j] == false ) {   //j행에는 퀸을 아직 배치하지 않았다면
                pos[i] = j;             // 퀸을 j행에 배치
                if ( i == 7 ) {         // 모든 열에 배치한 경우
                    //print();
                }
                else {
                    flag[j] = true;
                    set(i+1);
                    flag[j] = false;
                }
            }
        }
    }
    
    //
    static void set2(int i) {
    	//j는 행으로 계산    i는 열계산
    	for(int j=0;j<8;j++) {
    		if(flag[j] == false // i열에 퀸을 놧나 안놧나 체크
    			&& upFlag[i+j]==false // i+1하기전 위 대각선으로 퀸을 놓지 않게 체크
    			&& downFlag[i-j+7]==false // i+1 하기전 아래 대각선으로 퀸을 놓지 않게 체크
    		   ){ 
	    		pos[i] = j;
	    		if(i >=7) {
	    			print(i,j);
	    		}else {
	    			flag[j] = upFlag[i+j] = downFlag[i-j+7] = true;// boolean 의 기본값은 true;
	    			//flag의 대각 행의 flag값 체크넣기
	    			//pos[i]의 j값을 한번넣으면 flag는 false가되서
	    			//set(i+1) 의 다음동작으로 넘어간다
	    			set2(i+1);
	    			flag[j] = upFlag[i+j] = downFlag[i-j+7] = false;
	    		}
    		}
    	}
    }
    /*
     * n이 퀸의 갯수라고 한다면
     * 
     * 시간복잡도 : O(n²)--경우의수 1가지 , 
     * 아무조건이없는 8*8일경우 경우의수 1가지를 구하기 위해서 돌아가는 경우의수는
     * 이중 for문 처럼 돌아가서 전부 탐색하무로 n²
     * 
     * 
     * 묘든경우의 수를 구하는데 걸리는 시간복잡도는 (nⁿ)!
     * 이유는 퀸의 모든경우의수를 구하는 가지수는 64*63*62*61 이렇게 팩토리얼로 되어잇기때문에
     * n개의 퀸을 nxn의 체스판에 놓으면 저렇게 된다고 생각합니다
     * 
     * 조건을걸면 시간복잡도는 (nⁿ)!-(2ⁿ￣²)-2ⁿ
     * 가로세로 시간복잡도 = 2ⁿ￣²
     * 대각선 시간복잡도 = 2ⁿ
     * 
     * 
     * 공간복잡도 : O(n)
     * 사실 배열을 1로하는지 n개의 공간이라 n으로 하는지 모르겠는데.
     * 재귀함수라서 부른놈을그대로 쓰기때문에 o(n) 이라 생각합니다.
     * 
     * 둘다 맞는 답인진 모르겠는데 제가 계산할떈 이렇게 보입니다.
     * 
     * 
     */
    
    
    
    public static void main(String[] args) {
        set2(0);
        System.out.println("총 경우의수는 "+sum +" 가지");
    }
}
