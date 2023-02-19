import Lec04.JavaMoney

/***
 * # 코틀린에서 연산자를 다루는 방법
 *
 * 1. 기본적인 연산자들은 자바와 동일함
 * 2. Java와 다르게 객체를 비교할 때 비교연산자를 사용하면 자동으로 compareTo를 호출해줌
 * 3. 동등성과 동일성
 * * 동일성 : 객체의 레퍼런스까지 같은 경우 (같은객체인경우)
 * * 동등성 : 객체의 값이 같은 경우 (equals)
 * - 코틀린에서는 동일성을 볼 때는  '===',
 * - 동등성을 비교할 때는  '==' 를 사용한다.
 *
 * 4. 코틀린도 자바처럼 lazy 연산을 수행한다.
 * 5. 코틀린에서만 있는 특이한 연산자
 * - 1) in/!in : 컬렉션 범위에 포함되어 있다/있지않다
 * - 2) a..b : 반복문에서 a부터 b까지
 * - 3) a[i] : a에서 특정 인덱스 i로 값을 가져온다 // ex) 특정 문자열 가져올 때 str = "ABC" -> str[2] = "C"
 * - 4) a[i] = b  : a의 특정인덱스 i에 값을 넣는다
 *
 * 6. 객체마다 직접 연산자를 정의할 수 있다
 *
 */

fun main(){
    // 2.
    val m1: JavaMoney = JavaMoney(1_000L)
    val m2: JavaMoney = JavaMoney(2_000L)

    // Comparable 객체를 비교할 때 compareTo 가 자동적으로 호출되어서 굳이 써주지 않아도 됨 (<,>,<=,>=)
    if(m1 < m2){
        println("m2가 더 큽니다.")
    }
    //
    val money1 = JavaMoney(1_000)
    val money2 = money1
    val money3 = JavaMoney(1_000)

    println(money1 === money2)
    println(money1 === money3)
    println(money1 == money3)

}