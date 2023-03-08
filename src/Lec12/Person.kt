package Lec12

fun main(){
    println(Singleton.a)
}
class Person private constructor(
    var name: String,
    var age: Int,
){
    // kotiln에는 static 키워드 대신
    // companion object 블록에 정적 변수, 함수를 작성한다.


    companion object Factory : Log {
        val MIN_AGE = 1
        @JvmStatic // 이 어노테이션이 있으면 자바파일에서 직접 스태틱함수에 접근할수있다.
        fun newBabay(name: String): Person {
            return Person(name, MIN_AGE)
        }

        // Log클래스에 구현되어있는 추상메소드
        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory")
        }
    }

}