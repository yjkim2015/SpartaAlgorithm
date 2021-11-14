# 2주차 과제

## 문제 1
```
자바 프로그램에서는 메소드를 호출하고 실행할 때 프로그램 내부에서는 스택을 사용한다.
-> 자바 메모리구조와 함께 스택 동작 구조를 상세히 설명하라.
```

### 자바의 메모리 구조
#### Permanent Generation (Java 8 부터 `Metaspace`로 변경)
- "Perm Gen"이라고도 불림
- JVM에서 필요로 하는 애플리케이션에서 사용하는 `클래스`, `메서드`의 메타데이터를 포함하고 있음
- Runtime시 JVM에 의해 "Perm Gen"영역이 채워짐

#### Metaspace
- "Perm Gen"이 사라지고 Metaspace 영역 대체함
  - `java.lang.OutOfMemoryError: PermGen`가 더이상 이슈화 되지 않음
  - "Perm Gen"에서 관리하던 Static Object 변수, 상수는 `Heap 영역으로 이동`
- Native Memory 영역으로 OS가 크기 자동 조절
- 클래스 로더가 살아있는동안 메타데이터는 메타스페이스 영역에 생존하며 해제 불가

#### Code Cache
- JVM이 네이티브 코드로 컴파일된 바이트코드를 저장하는 공간
- 주로 JIT(Just-In-Time) 컴파일러가 사용함

#### Method Area
- 인스턴스 생성을 위한 필요 정보를 저장하는 공간
  - 필드, 메서드, 생성자 등...
- 각 데이터는 `Runtime Constant Pool`을 가지게 됨

#### Java Stack Memory
- 스레드의 실행에 사용 됨
- Heap 영역에 생성된 Object 타입의 데이터 참조값이 할당
- 메서드 내에서 사용되는 값을 저장
- 호출된 메서드의 지역변수, 매개변수, 리턴 값 및 연산 값을 임시 저장
- 임시 저장 공간이기 때문에 메서드의 사용이 끝나면 Stack 영역에서 해제
- 서로 다른 스레드끼리 접근 불가능

#### Java Heap Memory
- 동적으로 생성 된 객체 또는 배열이 저장되는 공간
- 몇개의 스레드가 존재하든 상관없이 단 하나의 Heap 영역만 존재
- 사용이 끝난 객체는 Gabage Collector가 정리함