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
- `<>`를 사용한 클래스를 제네릭 클래스라 한다. 이 기호 (`<>`)를 보통 다이아몬드라 한다.
- 제네릭 클래스를 사용할 때는 `Integer`, `String` 같은 타입을 미리 결정하지 않는다.
- 대신에 클래스명 오른쪽에 `<T>`와 같이 선언하면 제네릭 클래스가 된다. 여기서 `T`를 **타입 매개변수**라 한다.
이 타입 매개변수는 이후에 `Integer`, `String`으로 변할 수 있다.
- 그리고 클래스 내부에 `T` 타입이 필요한 곳에 `T value`와 같이 타입 매개변수를 적어두면 된다.

#### generic.ex1.BoxMain3

**생성 시점에 원하는 타입 지정** <br/>
제네릭 클래스는 다음과 같이 정의한다. `<>`(다이아몬드 기호) 안에 타입 매개변수를 정의하면 된다.
```java
class GenericBox<T>
```

제네릭 클래스는 생성하는 시점에 `<>` 사이에 원하는 타입을 지정한다.

```java
new GenericBox<Integer>()
```
이렇게 하면 앞서 정의한 `GenericBox`의 `T`가 다음과 같이 지정한 타입으로 변한 다음 생성된다.

**T에 Integer를 적용한 GenericBox 클래스**
```java
public class GenericBox<Integer> {
	private Integer value;
	
	public void set(Integer value) {
		this.value = value;
    }
	
	public Integer get() {
		return value;
    }
}
```
`T`가 모두 `Integer`로 변한다. 따라서 `Integer` 타입을 입력하고 조회할 수 있다.

이제 `set(Integer value)`이므로 이 메서드에는 `Integer` 숫자만 담을 수 있다.
```java
integerBox.set(10); // 성공
integerBox.set("문자100"); // Integer 타입만 허용, 컴파일 오류
```

`get()`의 경우에도 `Integer`를 반환하기 때문에 타입 캐스팅 없이 숫자 타입으로 조회할 수 있다.
```java
Integer integer = integerBox.get(); // Integer 타입 반환 (캐스팅 X)
```

`String`을 사용하면 다음과 같다.

```java
new GenericBox<String> ()
```

**T에 String을 적용한 GenericBox 클래스**
```java
public class GenericBox<String> {
	
	private String value;
	
	public set (String value) {
		this.value = value;
    }
	
	public String get() {
		return value;
    }
}
```
`T`가 모두 `String`으로 변한다. 따라서 문자열을 입력하고, 문자열을 그대로 조회할 수 있다.

**원하는 모든 타입 사용 가능** <br/>
제네릭 클래스를 사용하면 다음과 같이 `GenericBox` 객체를 생성하는 시점에 원하는 타입을 마음껏 지정할 수 있다.
```java
new GenericBox<Double>()
new GenericBox<Boolean>()
new GenericBox<MyClass>()
```
참고로 제네릭을 도입한다고 해서 앞서 설명한 `GenericBox<String>`, `GenericBox<Integer>`와 같은
코드가 실제 만들어지는 것은 아니다. 대신에 자바 컴파일러가 우리가 입력한 타입 정보를 기반으로 이런 코드가 있다고
가정하고 컴파일 과정에 타입 정보를 반영한다. 이 과정에서 타입이 맞지 않으면 컴파일 오류가 발생한다.

#### 타입 추론
```java
GenericBox<Integer> integerBox = new GenericBox<Integer>() // 타입 직접 입력
GenericBox<Integer> integerBox2 = new GenericBox<>() // 타입 추론
```
첫번째 줄의 코드를 보면 변수를 선언할 때와 객체를 생성할 때 `<Integer>`가 두 번 나온다. 자바는 왼쪽에 있는
변수를 선언할 때의 `<Integer>`를 보고 오른쪽에 있는 객체를 생성할 때 필요한 타입 정보를 얻을 수 있다. 따라서
두 번째 줄의 오른쪽 코드 `new GenericBox<>()`와 같이 타입 정보를 생략할 수 있다. 이렇게 자바가 스스로
타입 정보를 추론해서 개발자가 타입 정보를 생략할 수 있는 것을 타입 추론이라 한다. <br/>
참고로 타입 추론이 그냥 되는 것은 아니고, 자바 컴파일러가 타입을 추론할 수 있는 상황에만 가능하다. 쉽게 이야기해서
읽을 수 있는 타입 정보가 주변에 있어야 추론할 수 있다.

#### 정리
제네릭을 사용한 덕분에 코드 재사용과 타입 안전성이라는 두 마리 토끼를 모두 잡을 수 있었다.

---

# 제네릭 용어와 관례
제네릭의 핵심은 **사용할 타입을 미리 결정하지 않는다는 점**이다. 클래스 내부에서 사용하는 타입을 클래스를
정의하는 시점에 결정하는 것이 아니라 실제 사용하는 생성 시점에 타입을 결정하는 것이다. <br/>
이것을 쉽게 비유하자면 메서드의 매개변수와 인자의 관계와 비슷하다.

**메서드에 필요한 값을 메서드 정의 시점에 미리 결정**
```java
void method1() {
	print("hello");
}
```
- 메서드에 필요한 값을 이렇게 메서드 정의 시점에 미리 결정하게 되면, 이 메서드는 오직 "hello"라는 값만
출력할 수 있다. 따라서 재사용성이 떨어진다.

**메서드에 필요한 값을 인자를 통해 매개변수로 전달해서 결정**
```java
void method2(String param) {
	println(param);
}

void main() {
	method2("hello");
	method2("hi");
}
```
- 메서드에 필요한 값을 메서드를 정의하는 시점에 미리 결정하는 것이 아니라, 메서드를 실제 사용하는 시점으로
미룰 수 있다.
- 메서드에 매개변수(`String param`)를 지정하고, 메서드를 사용할 때 원하는 값을 인자(`"hello"`, `"hi"`)로
전달하면 된다.

**다양한 값을 처리하는 메서드**
```java
// method2("hello") 호출 예
void method2(String param = "hello") {
	println(param);
}

// method2("hi") 호출 예
void method2(String param = "hi") {
  println(param);
}
```
매개변수를 정의하고, 실행 시점에 인자를 통해 원하는 값을 매개변수에 전달했다. <br/>
이렇게 하면 이 메서드는 실행 시점에 얼마든지 다른 값을 받아서 처리할 수 있다. 따라서 재사용성이 크게 늘어난다.

#### 메서드의 매개변수와 인자
```java
void method(Strin param) // 매개변수

void main() {
	String arg = "hello";
	method(arg) // 인수 전달
}
```
- 매개변수(Parameter): `String param`
- 인자, 인수(Argument): `arg`

메서드의 매개변수에 인자를 전달해서 메서드의 사용값을 결정한다.

#### 제네릭 타입 매개변수와 타입 인자
제네릭도 앞서 설명한 메서드의 매개변수와 인자의 관계와 비슷하게 작동한다. <br/>
제네릭 클래스를 정의할 때 내부에서 사용할 타입을 미리 결정하는 것이 아니라, 해당 클래스를 실제 사용하는
생성 시점에 내부에서 사용할 타입을 결정하는 것이다. 차이가 있다면 **메서드의 매개변수는 사용할 값에 대한
결정을 나중으로 미루는 것이고, 제네릭의 타입 매개변수는 사용할 타입에 대한 결정을 나중으로 미루는 것**이다.

정리
- 메서드는 **매개변수**에 **인자**를 전달해서 사용할 값을 결정한다.
- 제네릭 클래스는 **타입 매개변수**에 **타입 인자**를 전달해서 사용할 타입을 결정한다.

제네릭에서 사용하는 용어도 매개변수, 인자의 용어를 그대로 가져다 사용한다. 다만 값이 아니라 **타입을 결정**하는
것이기 때문에 앞에 타입을 붙인다.
- 타입 매개변수: `GenericBox<T>`에서 `T`
- 타입 인자:
  - `GenericBox<Integer>`에서 `Integer`
  - `GenericBox<String>`에서 `String`

제네릭 타입의 타입 매개변수 `<T>`에 타입 인자를 전달해서 제네릭의 사용 타입을 결정한다. <br/>
`GenericBox<T>`
- `String` -> `GenericBox<String>`
- `Integer` -> `GenericBox<Integer>`

#### 용어 정리
- **제네릭(Generic) 단어**
  - 제네릭이라는 단어는 일반적인, 범용적인이라는 영어 단어 뜻이다.
  - 풀어보면 특정 타입에 속한 것이 아니라 일반적으로, 범용적으로 사용할 수 있다는 뜻이다.
- **제네릭 타입 (Generic Type)**
  - 클래스나 인터페이스를 정의할 때 타입 매개변수를 사용하는 것을 말한다.
  - 제네릭 클래스, 제네릭 인터페이스를 모두 합쳐서 제네릭 타입이라 한다.
    - 타입은 클래스, 인터페이스, 기본형(`int` 등)을 모두 합쳐서 부르는 말이다.
  - 예: `class GenericBox<T> { private T t; }`
  - 여기에서 `GenericBox<T>`를 제네릭 타입이라 한다.
- **타입 매개변수 (Type Parameter)**
  - 제네릭 타입이나 메서드에서 사용되는 변수로, 실제 타입으로 대체된다.
  - 예: `GenericBox<T>`
  - 여기에 `T`를 타입 매개변수라 한다.
- **타입 인자 (Type Argument)**
  - 제네릭 타입을 사용할 때 제공되는 실제 타입이다.
  - 예: `GenericBox<Integer>`
  - 여기에서 `Integer`를 타입 인자라 한다.

## 제네릭 명명 관례
타입 매개변수는 일반적인 변수명처럼 소문자로 사용해도 문제는 없다. <br/>
하지만 일반적으로 대문자를 사용하고 용도에 맞는 단어의 첫글자를 사용하는 관례를 따른다.

주로 사용하는 키워드는 다음과 같다.
- E - Element
- K - Key
- N - Number
- T - Type
- V - Value
- S, U, V etc. - 2nd, 3rd, 4th types

## 제네릭 기타
다음과 같이 한번에 여러 타입 매개변수를 선언할 수 있다.
```java
class Data<K, V> {}
```

#### 타입 인자로 기본형은 사용할 수 없다
제네릭의 타입 인자로 기본형(`int`, `double` ..)은 사용할 수 없다. 대신에 래퍼 클래스(`Integer`,
`Double`를 사용하면 된다.

## 로 타입 - raw type - generic.ex1.RawTypeMain
제네릭 타입을 사용할 때는 항상 `<>`를 사용해서 사용시점에 원하는 타입을 지정해야 한다. <br/>
그런데 다음과 같이 `<>`를 지정하지 않을 수 있는데, 이런 것을 로 타입(raw type), 또는 원시 타입이라한다.
```java
GenericBox integerBox = new GenericBox();
```
원시 타입을 사용하면 내부의 타입 매개변수가 `Object`로 사용된다고 이해하면 된다.

제네릭 타입을 사용할 때는 항상 `<>`를 사용해서 사용시점에 타입을 지정해야 한다. 그런데 왜 이런 로 타입을
지원하는 것일까? <br/>
자바의 제네릭이 자바가 처음 등장할 때 부터 있었던 것이 아니라 자바가 오랜기간 사용된 이후에 등장했기 때문에
제네릭이 없던 시절의 과거 코드와의 하위 호환이 필요했다. 그래서 어쩔 수 없이 이런 로 타입을 지원한다.

정리하면 로 타입을 사용하지 않아야 한다. <br/>
만약에 `Object` 타입을 사용해야 한다면 다음과 같이 타입 인자 `Object`를 지정해서 사용하면 된다.
```java
GenericBox<Object> integerBox = new GenericBox<>();
```

---

# 제네릭 활용 예제
이번에는 직접 클래스를 만들고, 제레릭도 도입해보자. <br/>
지금부터 사용할 `Animal` 관련 클래스들은 이후 예제에서도 사용하므로 `generic.animal`이라는 별도의
패키지에서 관리하겠다.

#### generic.animal.Animal
- 이름(`name`), 크기(`size`) 정보를 가지는 부모 클래스이다.
- `toString()`을 IDE를 통해서 오버라이딩 했다.

#### generic.animal.Dog
- `Animal`을 상속 받는다.
- 부모 클래스에 정의된 생성자가 있기 때문에 맞추어 `super(name, size)`를 호출한다.

#### generic.animal.Cat

#### generic.ex2.Box
- 객체를 보관할 수 있는 제네릭 클래스다.

#### generic.ex2.AnimalMain1
- `Box` 제네릭 클래스에 각각의 타입에 맞는 동물을 보관하고 꺼낸다.
- `Box<Dog> dogBox`: `Dog` 타입을 보관할 수 있다.
- `Box<Cat> catBox`: `Cat` 타입을 보관할 수 있다.
- `Box<Animal> animalBox`: `Animal` 타입을 보관할 수 있다.

여기서 `Box<Animal>`의 경우 타입 매개변수 `T`에 타입 인자 `Animal`을 대입하면 다음 코드와 같다.
```java
public class Box<Animal> {
	private Animal value;
	
	public void set(Animal value) {
		this.value = value;
    }
	
	public Animal get() {
		return value;
    }
}
```
- 따라서 `set(Animal value)`이므로 `set()`에 `Animal`의 하위 타입인 `Dog`, `Cat`도 전달할 수 있다.
- 물론 이 경우 꺼낼 때는 `Animal` 타입으로만 꺼낼 수 있다.

#### generic.ex2.AnimalMain2