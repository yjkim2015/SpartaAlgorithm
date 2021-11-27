package org.sparta.hellgorithm.week0304.homework.choi;

/*
유클리드 호제법
두수의 최대공약수를 구하는 방법이다.
두수 A = Ga, B = Gb (a와 b는 서로소) 이면 A,B 의 최대공약수는 G이다.
이때 A가 B보다 큰수라면 A = B * P + Q 이다.
즉 Q = A - B * P 이자 Q = G (a-bP)이다. 만일 이때 a-bP와 b가 서로소라면 B와 Q의 최대공약수는 G이다.
a - bP 와 b가 서로소 인걸 증명하는 과정을 보고 싶다면 다음 링크를 참조하자.
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=papers&logNo=140207307545

a-bp와 b는 서로소인 관계이기 때문에 늘 B와 Q의 최대공약수가 A와 B의 공약수가 같다.
즉 유클리드 호제법은 GCD(A,B) = GCD(B,A%B)이다.

유클리드 호제법을 활용하면 최소공배수 또한 쉽게 구할 수 있다.
A = Ga, B = Gb 이고 a,b를 서로소라고 한다면 이때 수의 최소 공배수는 G * a *b 이다.
A와 B를 곱하면 당연하게도 G^2 * a * b 이므로 이때 최대공약수인 G만 나누어주면된다.
즉 최소공배수 = A * B / gcd(A,B) 이다.
*/
public class GCD_02 {

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int gcd(int a, int b) {

        int big = max(a,b);
        int small = min(a,b);
        while(small > 0) {
            //gcd(a,b) == gcd(b,a%b)를 이용해서 a%b가 0이기 전의 값을 구한다.
            int tmp = small;
            small = big % small;
            big = tmp;
        }
        return big;
    }

    public static void main(String[] args) {
        System.out.println(gcd(13,15));
    }
}
