/***
 * 10강 클래스에서 상속을 다루는 방법
 * 1.추상클래스
 * 2. 인터페이스
 * 3. 클래스 상속시 주의할 점
 * 4. 상속 관련 지시어 정리
 *
 * */
fun main(){

    // 클래스 상속시 주의할 점
    /*
        1. open 을 사용한 클래스는 상속이 가능하다.
        2. open 을 사용한 클래스의 open 을 사용한 프로퍼티는 오버라이드가 가능하다.
        3. 다음의 경우에서 number는 어떤 값이 나올까?

     */
    Derived(300) // number = ?
    /*
        number는 0으로 나오는데, 그 이유는
        하위클래스 생성자에서 오버라이드 된 프로퍼티가 초기화 되기 전에
        상위클래스의 생성자에서 number라는 open 된 프로퍼티에 접근하기 때문이다

        다음과 같은 오류가 나오지 않기위해서는
        1. 상위클래스의 constructor와 init 블럭에서는 하위 클래스에서 접근할 수 있는 (open 키워드를 가진) 프로퍼티에 접근하지 않거나
            open 키워드를 사용하면 안된다
        2. final 프로퍼티를 사용한다
     */
}
open class Base(
    open val number: Int = 100
){
    init {
        println(number)
    }
}
class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived class")
    }
}
/**
 * Animal이라는 클래스를 Cat, Penguin 클래스가 상속하는 경우
 */
