#시간복잡도란
작동하는 알고리즘의 수행시간을 정량화 한것.


<h3>시간 복잡도 표기법</h3>
1.Big-O:Worst case를 나타내는 표기법.<br>
2.Big-Omega: Best case를 나타내는 표기법.<br>
3.Big-Theta:Average case를 나태는 표기법.<br>
일반적으로 빅-오 표기법을 사용한다.

<h3>시간 복잡도 계산</h3>
Big-O : O(N)<br>
알고리즘의 시간복잡도는 연산의 횟수 T를 구하는 방법이 주로 쓰인다.<BR>
통산적으로 1억번의 연산당 1초의 시간이 걸린다고 간주하여 알고리즘의 수행시간을 예측한다.

<h3>시간 복잡도 종류</h3>
상수형:시간계산도 O(1)이다. ex) 길이가 N인 배열에서 M번째 배열값을 출력.<br>
로그형:시간계산도 O(logN)이며 N개의 정렬된 수열에서 이분탐색 또는 우선순위 큐에서는 원소 삽입,삭제연산.<br>
선형:시간계산도 O(N)이며 정렬되지 않은 길이가 N인 배열에서 가장 작은 수 탐색.(단일 포문)
선형로그형: O(NlogN)이며 힙 정렬, 병합정렬.
2차형:(N^2): 버블정렬, 삽입정렬, 퀵 정렬(2중 포문)
3차형:(N^3) 플로이드-위셜 알고리즘(3중포문)
지수형:2^N 번호가 매겨진 N개의 동전을 던졌을때 나오는 경우의 수
팩토리얼형: 1부터 N까지의 숫자를 나열할 수 있는 모든 방법을 출력하는 함수.

일반적으로 시간복잡도는 계산를 때고 최고차항만을 나타낸다. 예를 들어 O(2N^2+N)일경우 O(N^2)으로 표기.
<hr>

#공간복잡도
알고리즘의 메모리 사용량에 대한 분석결과로, 알고리즘 문제를 해결하기 위해서 사용하는 메모리의 크기를 말한다.<BR>
S(p) = c + Sp(n) <br>
총 공간 요구 = 고정 공간 여부 + 가변 공간 여부<br>


```
int sum(int a[], int n)
{
  int x = 0;		
  for(int i = 0; i < n; i++) {
    x  = x + a[i];
  }
  return(x);
}
```
int arr[n] : 4*n byte<br>
int n: 4 bytes <br>
int x: 4 bytes <br>
int i: 4bytes <br>
총 4n+12의 공간복잡도를 차지하며 빅오표기법으로 나타내면  O(n)이다.
<hr>




# 과제

```markdown
1.  시간복잡도, 공간 복잡도 계산방법. -> 본인의 Readme에 별도로 작성 할것.

2. BinarySearch.java를 응용하여 이진 검색의 과정을 자세히 출력하는 프로그램을 작성하세요.

   각 행의 맨 왼쪽에 현재 검색하고 있는 요소의 인덱스를 출력하고, 검색 범위의 맨 앞 요소 위에 <-, 맨 끝 요소 위에 -> 현재 검색하고 있는 중앙 요소 위에 + 를 출력하도록 하세요.

3. 

   1). 자바에서 제공하는 Arrays.binarySearch를 이용하여 lesson BinarySearch 문제 풀기.

   2).Arrays.binarySearch를 이용하여 검색 실패 시 삽입포인트 값을 출력하는 프로그램을 작성하라.

   3). 자연정렬이란?

   4).  PhysExamSearch.java를 보고 Arrays.binarySearch와 java.util.Compator를 이용하여 시력에 대한 내림차순 정렬의 신체검사 데이터에서 특정 시력을 가진 사람을 검색하는 프로그램을 작성하라.
```

# 과제 1

## 시간 복잡도

> 기본 연산의 실행 횟수로 수행 시간을 평가

### 기본 연산

- 데이터 입출력
- 산술 연산
- 제어 연산

### 시간 복잡도

- Best Case
  - 빅 오메가 표기
  - 최선의 시나리오
- Worst Case
  - 빅 오 표기
  - 최악의 시나리오
- Average Case
  - 빅 세타 표기
  - 평균 시간

-> 알고리즘은 `최악의 경우`로 성능 파악. 즉 빅 오 표기인 `Worst Case`로 파악

### 빅 오 표기

#### O(1) - Constant

> 입력된 데이터 크기와 상관없이 항상 일정한 처리 시간이 걸림

```java
    public void printNumber(int n) {
        System.out.println(n);
    }
```

#### O(log₂n) - Logarithmic

> 입력된 데이터 크기가 커질수록 연산 횟수가 log₂n에 비례해서 처리 시간 증가

```java
        for (int i = 0; i < n; i *= 2) {
            ...
        }
```

#### O(n) - Linear

> 입력된 데이터 크기와 비례해서 처리 시간 증가

```java
        for (int i = 0; i < n; i++) {
            ...
        }
```

#### O(nlog₂n) - Linear-Logarithmic

> 입력된 데이터 크기가 커질수록 처리 시간이 로그 배 만큼 증가

- Merge Sort
- Heap Sort

#### O(n²) - Quadratic

> 입력된 데이터 크기가 커질수록 처리 시간이 제곱으로 증가

```java
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ...
            }
        }
```

#### O(2ⁿ) - Exponential

> 입력된 데이터 크기가 커질수록 처리 시간이 2ⁿ으로 증가

```java
    public int printNumber(int n) {
        if (n <= 1) {
            return n;
        }
        
        return printNumber(n - 1) + printNumber(n - 2);
    }
```

## 공간 복잡도

> 알고리즘에서 사용하는 메모리의 양

```java
    public int printNumber(int n) {
        int a = n;
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            b[i] = i;
        }
        
        return b[a];
    }
```

- a = 4byte
- b = 4byte * n

-> 4n + 4 => 데이터 크기가 증가할수록 선형적으로 증가하기 때문에 공간 복잡도는 `O(n)`다.

## 자연정렬

> 자연스러운 순서

- 1, 2, 3, 4, 5, 6 ...
- 문자열을 정렬할 때, 숫자 부분의 순서를 자연스럽게 맞추어 정렬

### 예시

#### 일반 문자열 정렬

- img1.jpg
- img10.jpg
- img100.jpg
- img1000.jpg
- img2.jpg
- img3.jpg

#### 자연정렬

- img1.jpg
- img2.jpg
- img10.jpg
- img21.jpg
- img30.jpg
- img100.jpg

