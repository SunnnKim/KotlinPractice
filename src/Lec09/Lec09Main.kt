import Lec09.Person

/***
 * 09강 코틀린애서 클래스를 다루는 방법
 * - Lec09.Person.kt 참고
 */

fun main(){
    val person: Person = Person("hi",1)
    println(person.name)
    person.age = 1000
    println(person.age)
    // 주생성자, 부생성자
    println("주생성자, 부생성자 순서확인 ")
    val person2: Person = Person()
}