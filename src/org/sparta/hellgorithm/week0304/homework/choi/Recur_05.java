package org.sparta.hellgorithm.week0304.homework.choi;


import org.sparta.hellgorithm.week02.homework.chw.IntStack_2;

public class Recur_05 {

    static void recur(int n) {
        if ( n > 0 ) {
            recur(n-2);
            System.out.println(n);
            recur(n-1);
        }
    }

    static void non_recur(int n) {
        IntStack_2 stack = new IntStack_2(n);
        boolean flag = false;
        while(!flag) {
            //조건에 맞는 값들 push 먼저 n-2씩 감소하며 푸쉬.
            while(n > 0) {
                stack.push(n);
                n = n - 2;
            }

            if(!stack.IsEmpty()) {
                //스택에 있는 값을 꺼내서 출력.
                n = stack.pop();
                System.out.println(n);
                //출력 후 n값을 n-1으로 변경하고 다시 while문 수행.
                n = n - 1;
            }
            else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        non_recur(4);
    }
}
