/** 9강 코틀린에서 클래스를 다루는 방법
 *
 * 1. 코틀린에서 필드를 만들면 getter와 setter가 자동으로 생성 → 코틀린에서의 프로퍼티
 * 2. 코틀린에서는 주생성자 필수
 * 3. 코틀린에서는 constructor 키워드를 사용하여 부생성자를 추가로 만들 수 있으나, default parameter나 정적팩토리 메소드를 추천함
 * 4. 실제 메모리에 존재하는 것과 무관하게 custom getter, setter를 만들 수 있다.
 *      → 함수로도 만들 수 있으나 프로퍼티인 것 처럼 존재
 * 5. backing field : custom getter, setter에서 무한루프를 막기 위해 자기 자신을 field라는 키워드로 사용함
 *
 *
 * */
fun main(){
    val person: Person = Person("hi",1)
    println(person.name)
    person.age = 1000
    println(person.age)
    // 주생성자, 부생성자
    println("주생성자, 부생성자 순서확인 ")
    val person2: Person = Person()
}

/** 1. 클래스와 프로퍼티
 * 코틀린에서는 기본이 public → 생략가능
 * 생성자는 클래스명에 써준다
 * Java : 프로퍼티 = 필드 + getter + setter
 * Kotlin : getter, setter 만들지 않아도 자동으로 생성됨(직접적으로 만들지 않아도 됨)
 * - constructor 지시어 생략가능
 * - 생성자로 프로퍼티를 만들 수 있기 때문에 다음과 같이 작성 할 수 있다
 * - . 필드를 통해 getter, setter를 바로 불러올 수 있다
 * - 자바클래스르 가져오더라도 .field로 값을 불러오거나 대입할 수 있다.
 */
class Person constructor(
    var name: String,
    var age: Int
){
    // 생성자 검증
    // 생성자가 호출되는 시점에 실행됨
    // 값을 적절히 만들어주거나, validation 로직을 추가하는 용도로 주로 사용
    init{
        if(age<0) throw IllegalArgumentException("나이는 $age 세일 수 없습니다.")
        println("주생성자") // 주생성자
    }
    /** 추가생성자
     * 	추가생성자 : constructor 키워드와 함께 사용
     * 	→ 가장 위에 있는 생성자(주생성자)는 반드시 존재해야하며 그 외 생성자(부생성자)가 필요할 때는 constructor 키워드를 사용하여 추가생성자 만듦
     * 	→ 주생성자에 파라미터가 하나도 없다면 생략이 가능함
     * 	→ 부생성자는 최종적으로 this로 주생성자를 호출해주어야 한다.
     * 	→ 부생성자는 body를 가질 수 있다.(로직 작성 가능)
     * 	부생성자 호출 시 본문의 호출순서 : 역순으로 호출
     * 	    - 초기화블록부터 호출
     * 	    - 부생성자 호출
     * 	    - n번째 부생성자..
     * BUT.. 부생성자 호출보다는 Defalut Parameter 사용을 권장함
     * Converting 과 같은 경우 (다른 객체로 바뀌어야하는 경우) 부생성자 사용가능
     *  → 정적팩토리메소드 추천 (생성자를 static함수로 만드는 것)
     *
     */
    // 호출은 역순으로 한다
    // 부생성자 1
    constructor(name: String): this(name, 1){ // age를 받지 않는 경우 1로 고정
        println("부생성자1")
    }
    // 부생성자 2
    constructor(): this("이름고정"){
        println("부생성자2")
    }
    /***
     * custom getter, setter
     *
     */
    // 방법1 :  함수로 만들기
    fun isAdult1(): Boolean = this.age >= 20
    // 방법2 : 프로퍼티처럼 만들기(custom getter)
    val isAdult2: Boolean
        get() = this.age >= 20 // getter 함수를 만들어 줌
    //표현방법만 다를 뿐 결과는 같다

    // custom getter는 변형할 수 있다
    var name2 = name
        get() = field.uppercase() // backing field : 무한루프를 막기위한 예약어, 자기 자신을 가리킴
    // field가 들어가는 이유
    // name(실제필드명)이 들어가게 되면 자기자신을 호출하는 경우가 되어
    // 무한루프가 발생하게된다
    // → custom getter에서 사용하는 경우는 드물었음
    // this.name으로 변경가능

    // custom setter
    var name3 = name
        set(value){
            field = value.uppercase()
        }

    // → setter 자체를 지양하기 때문에 custom setter도 잘 안쓴다.
}


