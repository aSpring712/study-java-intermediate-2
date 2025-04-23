# 1. 제네릭 - Generic1
# 제네릭이 필요한 이유
대부분의 최신 프로그래밍 언어는 제네릭(Generic) 개념을 제공한다. <br/>
처음 제네릭을 접하는 경우 내용을 이해하기 쉽지 않을 수 있다. 따라서 단계별로 천천히 진행하겠다. <br/>
제네릭이 왜 필요한지 지금부터 코드로 알아보자.

#### generic.ex1.IntegerBox
- 숫자를 보관하고 꺼낼 수 있는 단순한 기능을 제공한다.

#### generic.ex1.StringBox
- 문자열을 보관하고 꺼낼 수 있는 단순한 기능을 제공한다.

#### generic.ex1.BoxMain1
코드를 보면 먼저 숫자를 보관하는 `IntegerBox`를 생성하고, 그곳에 숫자 `10`을 보관하고, 꺼낸 다음에 출력했다.
참고로 오토 박싱에 의해 `int`가 `Integer`로 자동 변환된다. <br/>
다음으로 문자열을 보관하는 `StringBox`를 생성하고 그곳에 문자열 `"hello"`를 보관하고, 꺼낸 다음에 출력했다.

#### 문제
이후에 `Double`, `Boolean`을 포함한 다양한 타입을 담는 박스가 필요하다면 각각의 타입별로 `DoubleBox`,
`BooleanBox`와 같이 클래스를 새로 만들어야 한다. 담는 타입이 수십개라면, 수십개의 `XxxBox` 클래스를
만들어야 한다. <br/>
이 문제를 어떻게 해결할 수 있을까?

--- 

# 다형성을 통한 중복 해결 시도
`Object`는 모든 타입의 부모이다. 따라서 다형성(다형적 참조)를 사용해서 이 문제를 간단히 해결할 수 있을 것 같다.

#### generic.ex1.ObjectBox 
- 내부에 `Object value`를 가지고 있다. `Object`는 모든 타입의 부모이다. 부모는 자식을 담을 수 있으므로
세상의 모든 타입을 `ObjectBox`에 보관할 수 있다.

#### generic.ex1.BoxMain2
**실행 결과**
```java
integer = 10
str = hello
Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
	at generic.ex1.BoxMain2.main(BoxMain2.java:25)
```
잘 작동하는 것 같지만 몇 가지 문제가 있다.

**반환 타입이 맞지 않는 문제** <br/>
먼저 `integerBox`를 만들어서 숫자 `10`을 보관했다. 숫자를 입력하는 부분에는 문제가 없어 보이지만,
`integerBox.get()`을 호출할 때 문제가 나타난다.

`integerBox.get()`의 반환 타입은 `Object`이다.
```java
Object obj = integerBox.get();
```
  
`Integer = Object`는 성립하지 않는다. 자식은 부모를 담을 수 없다. 따라서 다음과 같이 `(Integer)` 타입
캐스팅 코드를 넣어서 `Object` 타입을 `Integer` 타입으로 직접 다운 캐스팅해야 한다.
```java
Integer integer = (Integer) integerBox.get() // 1
Integer integer = (Integer) (Object)value // 2
Integer integer = (Integer)value // 3
```

`stringBox`의 경우도 마찬가지이다. `stringBox.get()`이 `Object`를 반환하므로 다음과 같이 다운 캐스팅해야 한다.
```java
String str = (String) stringBox.get()
```

**잘못된 타입의 인수 전달 문제**
```java
integerBox.set("문자100");
```
개발자의 의도는 `integerBox`에는 변수 이름과 같이 숫자 타입이 입력되기를 기대했다. <br/>
하지만 `set(Object ..)` 메서드는 모든 타입의 부모인 `Object`를 매개변수로 받기 때문에 세상의 어떤 데이터도
입력받을 수 있다. 따라서 이렇게 문자열을 입력해도 자바 언어 입장에서는 아무런 문제가 되지 않는다.

잘못된 타입의 값을 전달하면 값을 꺼낼 때 문제가 발생한다.
```java
Integer result = (Integer) integerBox.get(); // 1
Integer result = (Integer) "문자100"; // 2
Integer result = (Integer) "문자100"; // 3. 예외 발생 String을 Integer로 캐스딩할 수 없다.
```

숫자가 들어가 있을 것으로 예상한 박스에는 문자열이 들어가 있었다. 결과적으로 다운 캐스팅시에 `String`을
`Integer`로 캐스팅 할 수 없다는 예외가 발생하고 프로그램ㅇ리 종료된다.

#### 정리
다형성을 활용한 덕분에 코드의 중복을 제거하고, 기존 코드를 재사용할 수 있게 되었다. 하지만 입력할 때 실수로
원하지 않는 타입이 들어갈 수 있는 타입 안전성 문제가 발생한다. 예를 들어서 `integerBox`에는 숫자만 넣어야 하고,
`stringBox`에는 문자열만 입력할 수 있어야 한다. 하지만 박스에 값을 보관하는 `set()`의 매개변수가 `Object`
이기 때문에 다른 타입의 값을 입력할 수 있다. 그리고 반환 시점도 `Object`를 반환하기 때문에 원하는 타입을
정확하게 받을 수 없고, 항상 위험한 다운 캐스팅을 시도해야 한다. 결과적으로 이 방식은 타입 안전성이 떨어진다.

지금까지 개발한 프로그램은 코드 재사용과 타입 안전성이라는 2마리 토끼를 한번에 잡을 수 없다. 코드 재사용을
늘리기 위해 `Object`와 다형성을 사용하면 타입 안전성이 떨어지는 문제가 발생한다.
- `BoxMain1`: 각각의 타입별로 `IntegerBox`, `StringBox`와 같은 클래스를 모두 정의
  - 코드 재사용 X
  - 타입 안전성 O
- `BoxMain2`: `ObjectBox`를 사용해서 다형성으로 하나의 클래스만 정의
  - 코드 재사용 O
  - 타입 안전성 X
- ``````

---

# 제네릭 적용
제네릭을 사용하면 코드 재사용과 타입 안전성이라는 두 마리 토끼를 한 번에 잡을 수 있다. <br/>
제네릭을 사용해서 문제를 해결해보자.

### 제네릭 적용 예제 - generic.ex1.GenericBox

---

# 제네릭 용어와 관례

---

# 제네릭 활용 예제