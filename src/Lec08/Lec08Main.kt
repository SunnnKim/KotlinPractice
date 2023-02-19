/**
 * 08강 코틀린에서 함수를 다루는 방법
 */
fun main(){
    repeat("Hello World!!") // default parameter
//    repeat("Hello World", false) // 잘못 사용한 default parameter
    repeat("Hello World!!", useNewLine = false) // named argument
}

/** 1. 함수 선언 문법
 *
함수는 클래스 안에 있을수도, 파일 최상단에 있을수도 있고 한 파일안에 여러 함수들이 있을 수 있음

- 함수가 하나의 결과값인 경우 block 대신 = 사용가능
- 이 경우 return 은 빼준다
- = 을 사용하여 함수를 정의해주는 경우에는 return 타입을 생략할 수 있다
- block {} 을 사용하는 경우에는 return 타입이 Unit(void)가 아니면 반드시 명시적으로 작성해주어야 함

예제) 두 정수를 받아 더 큰 정수를 반환하기
 *
 */
// 기본적인 코틀린 함수
// public 생략가능, ( 매개변수명: 타입)
// 반환타입 : Unit(void) 생략가능
// 접근지시어 fun 함수이름 (파라미터): 반환타입{}
fun max1(a: Int, b: Int): Int{
    return if(a>b){
        a
    }
    else{
        b
    }
}

// = 을 사용하는 경우, 반환타입, block 생략할 수 있다.
// 반환값 1개, 구문을 1번만 사용하는 경우 =을 사용할 수 있음
fun max2(a: Int, b: Int) = if(a>b) a else b
// block {} 을 사용하는 경우에는 return 타입이 Unit(void)가 아니면
// 반드시 명시적으로 작성해주어야 함

/** Default Parameter

1. 기능이 같으나 다양한 파라미터를 받는 함수 (오버로딩함수)
- 자바의 오버로딩은 각각 다른 파라미터를 받을 때마다 함수를 만들어야하는 불편함이 있음
- 코틀린은 Default Parameter 가 존재해서 기본 값을 설정해둘 수 있다
- 매개변수의 기본값을 설정하고 싶을 때 = 을 사용해서 지정해준다.
- 호출부에서 파라미터를 넣어주지 않으면 기본값을 사용한다.

예제) 주어진 문자열을 N번 출력하는 함수
 */
// num 기본값 = 3
// useNewLine 기본값 = true
fun repeat(str: String,
           num: Int = 3, // 기본값 3
           useNewLine: Boolean = true // 기본값 true
        ){
    for(i in 1..num){
        if(useNewLine){
            println(str)
        }else{
            print(str)
        }
    }
}

/** Named Argument
위의 예제에서 num은 기본값, useNewLine은 파라미터로 넣고 싶은 경우는 어떻게 해야할까?

repeat("Hello world", false) // 에러코드

이렇게 파라미터를 넣게되면 num에 false 가 매치되어 에러가 뜬다.
특정 파라미터는 값을 넣고 싶은 경우에는 파라미터명을 지정하여 값을 넣을 수 있다

repeat("Hello world", useNewLine = false)

------------------------------------------------------------------------------
# 매개변수 이름을 통해 직접 값을 지정하는 경우, 함수를 호출하는 쪽에서 명시해줄 수 있는데
이 매개변수를 **named argument**라고 한다

# Named Argument를 사용하요 builder를 직접 만들지 않고 builder의 장점을 가지게 된다
- 매개변수를 명확하게 구분할 수 있음

# 자바함수를 직접 가져오는 경우는 named argument를 사용할 수 없다
→ JVM에서 자바코드가 바이트코드로 변환됐을 때 파라미터명을 보존하고 있지 않기 때문에 사용할 수 없음

 */
//fun main(){
//    repeat("Hello world", useNewLine = false)
//}

/**
 # 가변인자
 - 자바에서 가변인사를 표현할 때는 ...를 사용한다
 - 코틀린도 마찬가지로 비슷한 개념을 사용하여 가변인자를 받아올 수 있다.
 - vararg 키워드를 매개변수명 앞에 붙이면 가변인자를 받아온다.
 -
 */

// 가변인자의 경우는 vararg 를 변수명 앞에 붙여준다
fun printAll(vararg strings: String){
    for(str in strings){
        println(str)
    }
}
// 가변인자로 함수 호출 시
fun print(){
    // 1. 자바의 ... 처럼 사용하기
    printAll("A", "B", "C")

    // 2. 배열을 전달하기
    val array = arrayOf("A", "B", "C")
    printAll(*array)
//    printAll(array) // 컴파일에러
    // 배열을 꺼낼 때는 앞에 *을 붙여주어야 한다
    // spread 연산자 : 배열안에 있는 것들을 .처럼 꺼내준다는 의미
}


/***
    @@@@ 정리 @@@@

    1. 함수의 문법은 자바와 다름
     - 접근지시어 fun 함수이름 (파라미터): 반환타입{}
    2. 바디가 하나의 값으로 간주되는 경우 블록을 없앨 수 있고 블록이 없다면 반환 타입을 없앨 수 있음
    3. 함수파라미터에 기본값 설정가능
    4. 함수 호출시 특정파라미터를 지정해서 넣어줄 수 있음
    5. 가변인자에는 vararg 키워드를 사용, 가변인자 함수를 배열과 호출할 때는 앞에 *(spread)를 붙여주어야 함


 */