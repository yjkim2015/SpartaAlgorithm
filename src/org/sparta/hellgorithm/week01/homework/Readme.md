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