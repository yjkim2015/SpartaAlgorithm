package org.sparta.hellgorithm.week05.lesson;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("하노이의 탑");
        System.out.println("원반 개수 : ");

        int n = stdIn.nextInt();

        //n개의 원반을 1번 기둥에서 3번 기둥으로 옮김.
        move(n, 1, 3);
    }

    //num개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int num, int x, int y) {

    }
}
