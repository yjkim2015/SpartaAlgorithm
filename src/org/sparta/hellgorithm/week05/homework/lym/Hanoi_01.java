package org.sparta.hellgorithm.week05.homework.lym;

import java.util.Scanner;

public class Hanoi_01 {
	public static int sum = 0;
	
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("하노이의 탑");
        System.out.println("원반 개수 : ");

        int n = stdIn.nextInt();
        //n개의 원반을 1번 기둥에서 3번 기둥으로 옮김.
        
        move(n, 1, 3);
        System.out.println(sum+"번");
    }

    //num개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int num, int x, int y) {
    	if(num <= 0) {
    		return;
    	}
    	sum++;
    	move(num-1,x,6-x-y); // num-1 개의 원반을 y가아닌 다른번호의 기둥으로 옮기는 작업
    	System.out.println( num+"번원반  "+x+"기둥  "+y+"기둥");
    	move(num-1,6-x-y,y); // num-1개의다른번호에있는 원반을 다시 num개를 y의 기둥으로 옮기는 작업
    }
    /*
     * 시간복잡도 : O(2ⁿ)
     * 머리가 빠가라 풀이를 봐도 이해를못하겟다
     * 일단 코드에 따라 식을 세우자면
     * F(n-1)+1+F(n-1) = 2F(n-1)+1 여기까진 이해가 갔다.
     * 여기서 n을 다시 2F(n-1)+1 에대입해넣으면 2제곱n이 된다는대
     * 자세하게 풀이를 써서 증명은 못하겠는대 2제곱n+1이 되는 거 까진 확인이 된다.
     * 하향식 분석법은 png 파일 참조
     * 
     */
    
    
    
    
    
    
    
    //공식 박은것
    static int resultFn(int i) {
    	// 하노이의 탑은 등비수열로 2의 n제곱 만큼 커짐
    	// 그러면 2의n제곱 만큼 다 더해주면됨
    	//1층 1번,  2층 3번,  3층 7번  , 4층 15번
    	
    	//1층은 1이니간 +1을하고 i는 -1 해준다;
    	if(i<=1) {
    		int result = sum+1;
    		sum = 0;
    		return result; 
    	}
    	--i;
    	sum +=  (int) Math.pow(2, i);
    	return resultFn(i);
    }
}
