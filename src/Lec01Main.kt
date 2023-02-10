
fun main(){
    // 가변
    var number1 = 10L // variable
    number1 = 5L
    // 불변
    val number2 = 10L; // value
//    number2 = 5L;

    // 코틀린에서는 타입을 명시적으로 작성하지 않아도 컴파일러가 추론해줌
    // 명시적으로 선언할 수 있음
    var a : Long = 10L

    // 코틀린에서 변수에 값을 할당하지 않아도 타입을 명시하면 에러가 나지 않지만
    // 값을 사용하거나 출력하는 경우 에러가 뜬다
    var b : Long
//    println(b) // 값을 초기화하지 않아서 에러남

    // val 컬렉션에도 값을 추가 할 수 있음 (초기화는 불가능)
    // * TIP
    // 코틀린에서 코드를 작성할 때 모든 값들은 val로 작성하되
    // 필요한 경우 var로 교체하면 디버깅도 쉽고 클린한 코드를 쓸 수 있게 됨

    /**
     * primitive vs. reference type
     * 연산시 기본형으로 선언해야 불필요한 객체 생성을 막음
     * 자바에서는 변수의 타입을 선언하지만
     * 코틀린에서는 참조형으로 선언하되, 연산이 필요한 경우는 컴파일러에서 자동으로 기본타입으로 지정하여 해줌(smart)
     * 코틀린 -> 자바 파일로 디컴파일하여 볼 수 있음
     * 즉, 코틀린에서는 개발자가 boxing/unboxing 을 고려하지 않아도 되도록 알아서 처리해준
     */

    // Nullable
    // 변수에 null이 들어갈 수 있음을 표현하는 방법
    // 타입 옆에 ?를 붙여줌
    // 변수명:타입 ?
    // null은 아예 다른 타입으로 간주된다

    var c:Long? = 1_000L

    // 객체의 인스턴스화
    // 자바 = new 를 사용하여 생성
    // 코틀린은 new 쓰지않는다
    var person:Person = Person();

}
fun printName(name: String?): String?{
    return null
}