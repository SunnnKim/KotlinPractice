import java.util.IllegalFormatCodePointException

/**
 * Type
 *
 * 1. 코틀린은 타입을 선언하지 않고도 추론한다
 * - 변수의 기본값을 보고 추론
 * - 자바 : 기본타입간의 변환이 암시적으로 이루어질 수 있음
 * - 코틀린 : 기본타입간의 변환이 명시적으로 이루어져야 함
 *
 * 2. instanceof 와 is
 * - Object 타입을 특정 객체로 캐스팅할때
 * 1) java : instanceof를 사용하여 Object가 객체의 타입과 같은 타입이라면 true 아니면 false 리턴
 * 2) Kotlin : is 를 사용
 * - 타입 캐스팅도 () 대신 as 를 사용
 * - 해당 타입이 아닌데 as 사용하여 변환시 mismatchTypeException
 *
 * 3. is / is not
 * - is : kotlin에서 instanceof 의 의미를 가짐
 * - !is => is not 의 의미
 *
 * 4. nullable 한 객체의 타입 변환
 * - as 에 ? 를 붙여준다
 * - nullable 객체도 파라미터로 받아오기 때문에 사용시 ? 및 safe call 필요
 *
 * 5. 코틀린의 특이한 타입 3가지
 * 1) Any
 * - 자바의 Object와 비슷한 타입
 * - primitive type의 최상위 타입도 Any
 * - hashCode()/toString()/equals() 함수 존재
 * - Any 자체로 null일수 없어 nullable 한 타입을 만들려면 Any? 로 표현
 *
 * 2) Unit
 * - 자바의 void 와 동일한 역할 (타입추론이 가능하여 생략가능)
 * - void와 다르게 Unit은 그 자체로 타입인자로 사용가능함
 * - 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입이라는 의미
 * (즉, 코틀린에서 Unit은 실제 존재하는 타입이라는 것을 표현?)
 *
 * 3) Nothing
 * - 함수가 정상적으로 끝나지 않았음을 표현하는 역할
 * - 무조건 예외를 반환하는 함수 or 무한루프함수
 *
 * 6. String interpolation / String indexing
 * - String에 변수 사용시 ${} 로 출력 가능
 * - 변수의 경우 $변수명으로 표현가능
 * * 변수만 사용하더라도 ${} 로 감싸는 것이 가독성, 일괄변환, 정규식활용 등의 측면에서 좋음
 * - 문자가공시 """""".trimIndent() 사용하여 편하게 문자쓸 수 있음
 * - indexing : charAt(i) -> str[i] 문자열가져올때 배열처럼 가져올 수 잇음
 *
 *
 *
 */

fun main(){

    // 1. 코틀린 타입의 추론
    // 1-1 정수/실수
    val num1 = 1 // Int - 정수
    val num2 = 1L // Long - 정수
    val f = 3.0f // Float - 실수
    val d = 3.0 // Double - 실수
    // 1-2 명시적 타입변환
    var num3 = 4
    var num4 = 4L
//    num4 = num3  //  mismatchTypeException Error
    num4 = num3.toLong() // Int -> Long 으로 명시적으로 to변환타입 메소드로 바꿔주어야 함
    // 1-3 nullable 변수
    var num5:Int? = 1
    var num6:Long = num5?.toLong()?:0

    // 2. as
    printAgeIfPerson(Person("",10))
    // 3. is / !is
    printObj(Person("name",100))
    // 4. nullable
    printAgeIfPersonNotNull(null)
    // 5.
    // 6.
    stringInterpolation()
    stringIndexing1();
    stringIndexing2(3,"ABCDE")
}

// 2. instanceof -> as
fun printAgeIfPerson(obj:Any){
   if( obj is Person){
       val person = obj as Person; // as 객체 --> 사실 생략가능
       println(person.age)
       println(obj.age) // smart check : 알아서 타입 추론해줌
   }
}
// 3. is/!is
fun printObj(obj:Any){
    if(obj !is Person){
        println("obj is not Person")
    }
    if(obj is Person) {
        println(obj.name)
    }
}
// 4. nullable 가능한 타입변환
fun printAgeIfPersonNotNull(obj:Any?){ // obj = nullable
    if( obj is Person){
        val person = obj as? Person
        // person이 nullable 이기 때문에 인스턴스 사용시 ?붙여야함
        println(person?.age) // person nullable이므로 safe call 붙여주기
    }
}

// 5. Kotlin Type
fun nothingFunction(msg:String):Nothing{
    throw IllegalArgumentException(msg)
}

// 6. String interpolation / String indexing
fun stringInterpolation(){
    val person = Person("김이름", 20) // 인스턴스의 변수인 경우
    var name = "박민수"
    val log = "제 이름은 ${person.name} 입니다. 나이는 ${person.age}세 입니다 "
    val log2 = "제 이름은 $name 입니다." // 변수 직접 쓰는 경우 $name 직접씀
    println(log)
}
fun stringIndexing1(){
    var name = "박민수"
    val str = """
        이렇게하면
        알아서
        띄어쓰기 
        해줍니다
        ${name}
    """.trimIndent()
    println(str)

}
fun stringIndexing2(num:Int, str:String){
    // 문자열 가져오기
    println("${num-1}번째 글자 ${str[num]}")
}
