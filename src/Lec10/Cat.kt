package Lec10

/***
 * 상속시에도 : (콜론)을 사용한다
 * 코드 컨벤션이 다름
 * ** 타입에서 사용하는 콜론은 var a: String 이런 식으로
 * -> 변수종류 변수명: 변수타입
 * ** 상속 시 사용하는 콜론은 : 옆을 띄워준다
 */
class Cat(
    species: String
) : Animal(species, 4) { // 상위클래스의 생성자를 바로 호출해야함

    override fun move() { // override 필수적으로 붙여줘야함
        println("고양이")
    }
}