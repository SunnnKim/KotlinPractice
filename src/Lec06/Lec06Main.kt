/***
 * # 코틀린에서 반복문을 다루는 방법
 *
 * 1. for-each
 * - 자바는 :, 코틀린은 in을 사용
 * 2. for
 * - 코틀린은 등차수열, in을 사용
 * - 그 외는 자바와 동일
 * 3. progression / range
 * 4. while
 * - 동일
 *
 */

fun main(){
    // 숫자가 들어있는 리스트를 하나씩 출력하는 예제
    foreachEx()
    // range 사용하여 출력
    rangeNum()
    // step 증감값 지정
    stepNum()
}
fun foreachEx(){
    // Iterable이 구현된 모든 객체에 사용할 수 있다.
    val numbers = listOf(1L, 2L, 3L)
    for(number in numbers){
        println(number)
    }
}

fun rangeNum(){
    /**
     * .. -> IntRange -> IntProgression을 상속받음 (등차수열)
     * 1..3은 1~3까지 등차수열을 만들어 준다는 의미
     * 등차수열은 (시작값, 끝값, 공차) 가 존재
     * downTo, step -> 함수(중위함수)
     * => 코틀린에서 for문은 등차수열을 이용함
     */
    // 인덱스의 범위를 줄 때
    // 1. 증가하는경우 .. 사용
    for(num in 1..3){
        println(num)
    }
    // 2. 감소하는경우 downTo 사용
    for(num in 3 downTo 1){
        println(num)
    }
}

fun stepNum(){
    // 증가하는 값을 지정해주기
    for(num in 1 .. 10 step 2){
        println("2스텝증가 $num")
    }
    // 감소하는값 지정
    for(num in 10 downTo 1 step 3){
        println("3스텝감소 $num")
    }
}
// 자바와 동일함
fun whileEx() {
    var i = 0;

    while (i <= 3) {
        println(i)
        i++;
    }
}