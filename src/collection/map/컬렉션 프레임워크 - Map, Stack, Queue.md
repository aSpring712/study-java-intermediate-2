# 9. 컬렉션 프레임워크 - Map, Stack, Queue
# 컬렉션 프레임워크 - Map 소개 1
`Map`은 키-값의 쌍을 저장하는 자료 구조이다.
- 키는 맵 내에서 유일해야 한다. 그리고 키를 통해 값을 빠르게 검색할 수 있다.
- 키는 중복될 수 없지만, 값은 중복될 수 있다.
- `Map`은 순서를 유지하지 않는다.

#### 컬렉션 프레임워크 - Map
자바는 `HashMap`, `TreeMap`, `LinkedHashMap` 등 다양한 `Map` 구현체를 제공한다. 이들은 `Map` 인터페이스의
메서드를 구현하며, 각기 다른 특성과 성능 특징을 가지고 있다.

#### Map 인터페이스의 주요 메서드
- `put(K key, V value)`: 지정된 키와 값을 맵에 저장한다. (같은 키가 있으면 값을 변경) 
- `putAll(Map<? extends K, ? extends V> m)`: 지정된 맵의 모든 매핑을 현재 맵에 복사한다. 
- `putIfAbsent(K key, V value)`: 지정된 키가 없는 경우에 키와 값을 맵에 저장한다. 
- `get(Object key)`: 지정된 키에 연결된 값을 반환한다. 
- `getOrDefault(Object key, V defaultValue)`: 지정된 키에 연결된 값을 반환한다. 키가 없는 경우 `defaultValue`로
지정한 값을 대신 반환한다.
- `remove(Object key)`: 지정된 키와 그에 연결된 값을 맵에서 제거한다. 
- `clear()`: 맵에서 모든 키와 값을 제거한다. 
- `containsKey(Object key)`: 맵이 지정된 키를 포함하고 있는지 여부를 반환한다. 
- `containsValue(Object value)`: 맵이 하나 이상의 키에 지정된 값을 연결하고 있는지 여부를 반환한다. 
- `keySet()`: 맵의 키들을 `Set` 형태로 반환한다.
- `values()`: 맵의 값들을 `Collection` 형태로 반환한다. 
- `entrySet()`: 맵의 키-값 쌍을 `Set<Map.Entry<K, V>>` 형태로 반환한다. 
- `size()`: 맵에 있는 키-값 쌍의 개수를 반환한다. 
- `isEmpty()`: 맵이 비어있는지 여부를 반환한다.

이 중에 `HashMap`을 가장 많이 사용한다.

#### collection.map.MapMain1
#### 키 목록 조회
`Set<String> keySet = studentMap.keySet()` <br/>
`Map`의 키는 중복을 허용하지 않는다. 따라서 `Map`의 모든 키 목록을 조회하는 `keySet()`을 호출하면, 중복을 허용하지
않는 자료 구조인 `Set`을 반환한다.

#### 키와 값 목록 조회
`Map`은 키와 값을 보관하는 자료 구조이다. 따라서 키와 값을 하나로 묶을 수 있는 방법이 필요하다. 이때 `Entry`를 사용한다. <br/>
`Entry`는 키-값의 쌍으로 이루어진 간단한 객체이다. `Entry`는 `Map` 내부에서 키와 값을 함께 묶어서 저장할 때 사용한다. <br/>
쉽게 이야기해서 우리가 `Map`에 키와 값으로 데이터를 저장하면 `Map`은 내부에서 키와 값을 하나로 묶는 `Entry` 객체를 만들어서
보관한다. 참고로 하나의 `Map`에 여러 `Entry`가 저장될 수 있다. <br/>
참고로 `Entry`는 `Map` 내부에 있는 인터페이스이다. 우리는 구현체보다는 이 인터페이스를 사용하면 된다.

#### 값 목록 조회
`Collection<Integer> values = studentMap.values()` <br/>
`Map`의 값 목록을 중복을 허용한다. 따라서 중복을 허용하지 않는 `Set`으로 반환할 수는 없다. 그리고 입력 순서를 보장하지 않기
때문에 순서를 보장하는 `List`로 반환하기도 애매하다. 따라서 단순히 값의 모음이라는 의미의 상위 인터페이스인 `Collection`으로
반환한다.

---

# 컬렉션 프레임워크 - Map 소개 2
`Map`의 기능을 더 알아보자. <br/>
같은 키로 다른 데이터를 저장하면 어떻게 될까?

#### collection.map.MapMain2
`Map`에 값을 저장할 때 같은 키에 다른 값을 저장하면 기존 값을 교체한다. <br/>
`studentA=90`에서 `studentA=100`으로 변경된 것을 확인할 수 있다.

만약 같은 학생이 `Map`에 없는 경우에만 데이터를 저장하려면 어떻게 해야할까?

#### collection.map.MapMain3
`putIfAbsent()`는 영어 그대로 없는 경우에만 입력하라는 뜻이다. 이 메서드를 사용하면 키가 없는 경우에만 데이터를 저장하고
싶을 때 코드 한줄로 편리하게 처리할 수 있다.

---

# 컬렉션 프레임워크 - Map 구현체
자바의 `Map` 인터페이스는 키-값 쌍을 저장하는 자료 구조이다. `Map`은 인터페이스이기 때문에, 직접 인스턴스를 생성할 수는 없고,
대신 `Map` 인터페이스를 구현한 여러 클래스를 통해 사용할 수 있다. 대표적으로 `HashMap`, `TreeMap`, `LinkedHashMap`이
있다.

### Map vs Set
그런데 `Map`을 어디서 많이 본 것 같지 않은가? `Map`의 키는 중복을 허용하지 않고, 순서를 보장하지 않는다. <br/>
`Map`의 키가 바로 `Set`과 같은 자료 구조이다. 그리고 `Map`은 모든 것이 `Key`를 중심으로 동작한다. <br/>
`Value`는 단순히 `Key` 옆에 따라 붙은 것 뿐이다. `Key` 옆에 `Value`만 하나 추가해주면 `Map`이 되는 것이다. <br/>
`Map`과 `Set`은 거의 같다. 단지 옆에 `Value`를 가지고 있는가 없는가의 차이가 있을 뿐이다.

이런 이유로 `Set`과 `Map`의 구현체는 거의 같다.
- `HashSet -> HashMap`
- `LinkedHashSet -> LinkedHashMap`
- `TreeSet -> TreeMap`

**참고**: 실제로 자바 `HashSet`의 구현은 대부분 `HashMap`의 구현을 가져다 사용한다. `Map`에서 `Value`만 비워두면
`Set`으로 사용할 수 있다.

각각의 특징을 알아보자. <br/>
참고로 앞서 `Set`에서 학습한 내용과 거의 같다.

### 1. HashMap:
- **구조**: `HashMap`은 해시를 사용해서 요소를 저장한다. 키`(Key)` 값은 해시 함수를 통해 해시 코드로 변환되고,
이 해시 코드는 데이터를 저장하고 검색하는 데 사용된다.
- **특징**: 삽입, 삭제, 검색 작업은 해시 자료 구조를 사용하므로 일반적으로 상수 시간(`O(1)`)의 복잡도를 가진다.
- **순서**: 순서를 보장하지 않는다.

### 2. LinkedHashMap
- **구조**: `LinkedHashMap`은 `HashMap`과 유사하지만, 연결 리스트를 사용하여 삽입 순서 또는 최근 접근 순서에
따라 요소를 유지한다.
- **특징**: 입력 순서에 따라 순회가 가능하다. `HashMap`과 같지만 입력 순서를 링크로 유지해야 하므로 조금 더 무겁다. 
- **성능**: `HashMap`과 유사하게 대부분의 작업은 `O(1)`의 시간 복잡도를 가진다. 
- **순서**: 입력 순서를 보장한다. 

### 3. TreeMap
- **구조**: `TreeMap`은 레드-블랙 트리를 기반으로 한 구현이다. 
- **특징**: 모든 키는 자연 순서 또는 생성자에 제공된 `Comparator`에 의해 정렬된다. 
- **성능**: `get`, `put`, `remove`와 같은 주요 작업들은 `O(log n)`의 시간 복잡도를 가진다. 
- **순서**: 키는 정렬된 순서로 저장된다.

**참고**: 트리에 대한 이론적인 내용은 여기서 다루지 않는다. 트리 구조에 대해서 자세히 알고 싶다면 자료 구조와 알고리즘을
학습하자.

`HashMap`, `LinkedHashMap`, `TreeMap`의 특징을 코드로 확인해보자.

#### collection.map.JavaMapMain
- `HashMap`: 입력한 순서를 보장하지 않는다. 
- `LinkedHashMap`: 키를 기준으로 입력한 순서를 보장한다. 
- `TreeMap`: 키 자체의 데이터 값을 기준으로 정렬한다. 

### 자바 HashMap 작동 원리
자바의 `HashMap`은 `HashSet`과 작동 원리가 같다. <br/>
`Set`과 비교하면 다음과 같은 차이가 있다.
- `Key`를 사용해서 해시 코드를 생성한다.
- `Key` 뿐만 아니라 값(`Value`)을 추가로 저장해야 하기 때문에 `Entry`를 사용해서 `Key`, `Value`를 하나로 묶어서
저장한다.

이렇게 해시를 사용해서 키와 값을 저장하는 자료 구조를 일반적으로 해시 테이블이라 한다. <br/>
앞서 학습한 `HashSet`은 해시 테이블의 주요 원리를 사용하지만, 키-값 저장 방식 대신 키만 저장하는 특수한 형태의 해시 테이블로
이해하면 된다.

#### 주의!
`Map`의 `Key`로 사용되는 객체는 `hashCode()`, `equals()`를 반드시 구현해야 한다.

#### 정리
실무에서는 `Map`이 필요한 경우 `HashMap`을 많이 사용한다. 그리고 순서 유지, 정렬의 필요에 따라서 `LinkedHashMap`,
`TreeMap`을 선택하면 된다.

---

# 스택 자료 구조
### 스택(Stack) 구조
다음과 같은 1, 2, 3 이름표가 붙은 블록이 있다고 가정하자. <br/>
[ 1 ] <br/>
[ 2 ] <br/>
[ 3 ] 

이 블록을 아래쪽은 막혀 있고, 위쪽만 열려있는 통에 넣는다고 생각해보자. 위쪽만 열려있기 때문에 위쪽으로 블록을 넣고,
위쪽으로 블록을 빼야 한다. 쉽게 이야기해서 넣는 곳과 빼는 곳이 같다.

**push()** <br/>
블록은 1 -> 2 -> 3 순서대로 넣는다고 가정하자.

이번에는 넣은 블록을 빼자. <br/>
**pop()** <br/>
블록을 빼려면 위에서부터 순서대로 빼야한다. <br/>
블록은 3 -> 2 -> 1 순서로 뺄 수 있다.

정리하면 다음과 같다.
1(넣기) -> 2(넣기) -> 3(넣기) -> 3(빼기) -> 2(빼기) -> 1(빼기)

#### 후입 선출(LIFO, Last In First Out)
여기서 가장 마지막에 넣은 3번이 가장 먼저 나온다. 이렇게 나중에 넣은 것이 가장 먼저 나오는 것을 후입 선출이라 하고,
이런 자료 구조를 스택이라 한다.

전통적으로 스택에 값을 넣는 것을 `push`라 하고, 스택에서 값을 꺼내는 것을 `pop`이라 한다.

자바가 제공하는 스택 자료 구조를 사용해보자.

#### collection.deque.StackMain
실행 결과를 보면, 1, 2, 3으로 입력하면 3, 2, 1로 출력되는 것을 확인할 수 있다. 나중에 입력한 값이 가장 먼저 나온다.

#### 주의! - Stack 클래스는 사용하지 말자
자바의 `Stack` 클래스는 내부에서 `Vector`라는 자료 구조를 사용한다. 이 자료 구조는 자바 1.0에 개발되었는데, 지금은
사용되지 않고 하위 호환을 위해 존재한다. 지금은 더 빠른 좋은 자료 구조가 많다. 따라서 `Vector`를 사용하는 `Stack`도
사용하지 않는 것을 권장한다. 대신에 이후에 설명할 `Deque`를 사용하는 것이 좋다.

---

# 큐 자료 구조
#### 선입선출(FIFO, First In First Out)
후입 선출과 반대로 가장 먼저 넣은 것이 가장 먼저 나오는 것을 선입 선출이라 한다. 이런 자료 구조를 큐(Queue)라 한다.

**offer** <br/>
[3] <br/>
[2] <br/>
[1] <br/>

**poll** <br/>
정리하면 다음과 같다. <br/>
1(넣기) -> 2(넣기) -> 3(넣기) -> 1(빼기) -> 2(빼기) -> 3(빼기)

전통적으로 큐에 값을 넣는 것을 `offer`라 하고, 큐에서 값을 꺼내는 것을 `poll`이라 한다.

#### 컬렉션 프레임워크 - Queue
- `Queue` 인터페이스는 `List`, `Set`과 같이 `Collection`의 자식이다.
- `Queue`의 대표적인 구현체는 `ArrayDeque`, `LinkedList`가 있다.
- `Deque`는 조금 뒤에 설명한다.

참고로 `LinkedList`는 `Deque`와 `List` 인터페이스를 모두 구현한다.

```java
public class LinkedList<E> extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable {}
```

`ArrayDeque`를 통해 `Queue`를 사용해보자.

#### collection.deque.QueueMain
실행 결과를 보면 1, 2, 3으로 입력하면 1, 2, 3으로 출력되는 것을 확인할 수 있다. 가장 먼저 입력한 값이 가장 먼저 나온다.

---

# Deque 자료 구조
"Deque"는 "Double Ended Queue"의 약자로, 이 이름에서 알 수 있듯이, Deque는 양쪽 끝에서 요소를 추가하거나 제거할 수
있다. Deque는 일반적인 큐(Queue)와 스택(Stack)의 기능을 모두 포함하고 있어, 매우 유연한 자료 구조이다. <br/>
데크, 덱 등으로 부른다.

- `offerFirst()`: 앞에 추가한다. 
- `offerLast()`: 뒤에 추가한다. 
- `pollFirst()`: 앞에서 꺼낸다. 
- `pollLast()`: 뒤에서 꺼낸다.

`Deque`의 대표적인 구현체는 `ArrayDeque`, `LinkedList`가 있다.

#### collection.deque.DequeMain

입력 순서는 다음과 같다.
- 앞으로 1을 추가한다. [1]
- 앞으로 2를 추가한다. [2, 1] (앞으로 2를 추가했으므로 기존에 있던 1이 뒤로 밀려난다)
- 뒤로 3을 추가한다. [2, 1, 3]
- 뒤로 4를 추가한다. [2, 1, 3, 4]

앞에서 2번 꺼내면 2, 1이 꺼내진다. 다음으로 뒤에서 2번 꺼내면 4, 3이 꺼내진다.

### Deque 구현체와 성능 테스트
`Deque`의 대표적인 구현체는 `ArrayDeque`, `LinkedList`가 있다. 이 둘 중에 `ArrayDeque`가 모든 면에서 더 빠르다.

**100만 건 입력(앞, 뒤 평균)**
- `ArrayDeque`: 110ms
- `LinkedList`: 480ms

**100만 건 (앞, 뒤 평균)**
- `ArrayDeque`: 9ms
- `LinkedList`: 20ms

둘의 차이는 `ArrayList` vs `LinkedList`의 차이와 비슷한데, 작동 원리가 하나는 배열을 하나는 동적 노드 링크를 사용하기
때문이다. <br/>
`ArrayDeque`는 추가로 특별한 원형 큐 자료 구조를 사용하는데, 덕분에 앞, 뒤 입력 모두 O(1)의 성능을 제공한다. 물론
`LinkedList`도 앞 뒤 입력 모두 O(1)의 성능을 제공한다. <br/>
이론적으로 `LinkedList`가 삽입 삭제가 자주 발생할 때 더 효율적일 수 있지만, 현대 컴퓨터 시스템의 메모리 접근 패턴,
CPU 캐시 최적화 등을 고려할 때 배열을 사용하는 `ArrayDeque`가 실제 사용 환경에서 더 나은 성능을 보여주는 경우가 많다.

**참고**: 원형 큐에 대한 이론적인 내용은 여기서 다루지 않는다. 해당 내용을 자세히 알고 싶다면 자료 구조와 알고리즘을 학습하자.

---

# Deque와 Stack, Queue
`Deque`는 양쪽으로 데이터를 입력하고 출력할 수 있으므로, 스택과 큐의 역할을 모두 수행할 수 있다. <br/>
`Deque`를 `Stack`과 `Queue`로 사용하기 위한 메서드 이름까지 제공한다.

**Deque**
- `offerFirst()`
- `offerLast()`
- `poolFirst()`
- `poolLast()`

**Deque - Stack**
- `push()`를 호출하면 앞에서 입력한다.
- `pop()`을 호출하면 앞에서 꺼낸다.

**Deque - Queue**
- `offer()`를 호출하면 뒤에서 입력한다.
- `poll()`을 호출하면 앞에서 꺼낸다.

#### collection.deque.DequeStackMain
`Deque`에서 `Stack`을 위한 메서드 이름까지 제공하는 것을 확인할 수 있다. 자바의 `Stack` 클래스는 성능이 좋지 않고
하위 호환을 위해서 남겨져 있다. `Stack` 자료 구조가 필요하면 `Deque`에 `ArrayDeque` 구현체를 사용하자.

#### collection.deque.DequeQueueMain
`Deque`에서 `Queue`를 위한 메서드 이름까지 제공하는 것을 확인할 수 있다. `Deque` 인터페이스는 `Queue` 인터페이스의
자식이기 때문에, 단순히 `Queue`의 기능만 필요하면 `Queue` 인터페이스를 사용하고, 더 많은 기능이 필요하다면 `Deque`
인터페이스를 사용하면 된다. 그리고 구현체로 성능이 빠른 `ArrayDeque`를 사용하자.

---

# 문제와 풀이 풀이1 - Map1
## 문제2 - 공통의 합
#### collection.map.quiz.CommonKeyValueSum1_1, CommonKeyValueSum1_2
- `Map`을 생성할 때 `Map.of()`를 사용하면 편리하게 `Map`을 생성할 수 있다.
- `Map.of()`를 사용해서 생성한 `Map`은 불변이다. 따라서 내용을 변경할 수 없다.

#### collection.map.quiz.WordFrequencyTest1_1, WordFrequencyTest1_2
- `getOrDefault()` 메서드를 사용하면 키가 없는 경우 대신 사용할 기본 값을 지정할 수 있다.

# 문제와 풀이2 - Map2
## 문제7 - 장바구니
#### collection.map.quiz.cart.Product
- `Map`의 Key로 `Product`가 사용된다. 따라서 반드시 `hashCode()`, `equals()`를 재정의해야 한다.

# 문제와 풀이3 - Stack
## 문제1 - 간단한 히스토리 확인
- `Stack`을 사용해도 되지만 `Deque` 인터페이스에서 `ArrayDeque` 구현체를 사용하는 것이 성능상 더 나은 선택이다.

#### collection.deque.quiz.stack.SimpleHistoryTest