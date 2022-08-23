/***
 * # 코틀린에서 조건문을 다루는 방법
 *
 * 1. if문
 * - 자바에서 if-else 는 Statement (하나의 문장, 하나의 값으로 도출되지 않음)
 * - 코틀린에서 if-else 는 expression (하나의 값으로 도출되는 문장)
 * ---> return 으로 출력할 수 있음(값이있기때문)
 * ---> 코틀린에서는 if-else가 expression 이기 때문에 3항연산자가 없음
 *
 * 2. 사이값
 * - 코틀린에서 숫자형변수의 값의 범위를 나타낼 때 in ...을 사용할 수 있음
 *
 * 3. Switch case
 * - 코틀린에서는 Switch case 대신 when 을 사용함
 * - 아래 예제로 확인
 * when(값){
 *    (조건부) -> 구문
 *    else -> 디폴트구문
 * }
 * 1) 조건부 : 어떠한 expression 도 올 수 있음 (is, in ...등등) // 4번예제
 * 2) 조건부에 여러 조건을 동시에 검사할 수 있음 (,로 구분) // 5번예제
 * 3) 값이 없어도 when 조건문 성립가능 (6번)
 * 4) Enum class, Sealed class 와 함께사용하면 좋음
 */

fun main(){

}

fun validateScoreIsNotNegative(score:Int){
    if(score < 0 ){
        throw IllegalArgumentException("${score}은 0보다 작을 수 없습니다.")
    }
}
// 코틀린에서 if-else 문은 expression
fun getPassOrFail(score:Int) : String{
    return if(score>=50) {
        "P"
    }else{
        "F"
    }
}
// 2.
// 0~100 사이의 숫자범위에 있는 경우
fun ifNumber(score:Int){
    if(score in 0..100){
    }
}

// 3.
// switch case -> when
// when(비교할대상)
// 값1 -> 결과1
// 값2 -> 결과2
// else -> 나머지결과 (default)
// if-else와 마찬가지로 리턴가능
// 다양한 조건을 가지고 분기할 수 있음
fun getGradeWithSwitch(score:Int):String{
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

// 4.
fun startsWithA(obj:Any):Boolean{
    return when(obj){
        is String -> startWith("A") // type 비교하는 is 사용가능
        else -> false
    }
}
// 5
fun judgeNumber(number:Int){
    when (number){
        1,0,-1 -> println("number 1, 0, -1")
        else -> println("else")
    }
}

// 6
fun judgeNumber2(number:Int){
    when {
        number == 0 -> println("number = 0")
        number % 2 == 0 -> println("even number")
        else -> println("odd number")
    }
}