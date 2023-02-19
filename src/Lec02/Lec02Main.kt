    /**
     * 2강 코틀린에서 null을 다루는 방법
     *
     * 요약
     * 1. 코틀린에서 null이 들어갈 수 있는 타입은 완전히 다르게 간주함
     * 2. 한번 null 검사를 하면 non-null 임을 컴파일러가 알 수 있음
     * 3. null이 아닌 경우에만 호출되는 Safe Call이 있음(?.)
     * 4. null인 경우에만 호출되는 Elvis 연산자가 있다 (?:)
     * 5. null 이 절대 아닌 경우 사용할 수 있는 null아님 단언이 있다 (!!)
     * 6. Kotlin에서 Java 코드를 사용할 때 플랫폼 타입 사용에 유의 해야한다.
     * (자바 코드를 읽으며 null 가능성 확인/ 코틀린으로 랩핑)
     *
     * ? : 해당 변수/리턴값/아규먼트 등의 값에 null 이 가능하다는 것을 명시적으로 표시
     * 코틀린에서는 null이 가능한 타입을 완전히 다르게 취급한다 -> ?을 붙여 표시
     *
     *
     */
    // 리컨값이 null이 될 수 없는 함수 (return boolean)
    fun startsWithA1(str:String?) : Boolean {
        return str?.startsWith("A")
            ?: throw IllegalArgumentException("null 이다")
    }
    // 리턴값이 null이 나올 수 없는 함수임 (return Boolean)
    fun startsWithA2(str:String?) : Boolean? {
        return str?.startsWith("A")
    }
    // return T/F 만 가능
    fun startsWithA3(str:String?) : Boolean {
        return str?.startsWith("A") ?: false
    }

    /**
     * *** null이 가능한 타입만을 위한 기능
     * 1. Safe Call

     */
    fun main(){
        val str: String? = "ABC";
        // 1. safe call
        // - null이 가능한 타입에 ?을 붙여 메소드를 호출하면 null인 경우 뒤에 함수를 실행시키지 않고 null을 리턴한다
//        println(str.length); // -> null이 가능한 변수이기 때문에 컴파일에러
        println(str?.length); // str = null인 경우 length 를 실행하지 않고 null을 리턴함
        // 2. Elvis 연산자
        var str2 :String? = "aaa";
        str2?.length ?: 0;
        println(str2) // null이면 0 호출

    }

    /**
     * nullable 이지만 구조상 null이 올 수 없는 경우*
     */
    fun startWith(str:String?) :Boolean{
        return str!!.startsWith("A") // 혹시나 null이 들어오면 NPE 들어옴
    }

    /**
     * 자바와 코틀린을 함께 개발하는 경우,
     * 코틀린은 java의 Annotation을 이해한다
     * -> 자바의 @Nullable, @NotNull 어노테이션을 읽을 수 잇음
     * But, 어노테이션이 없다면 코틀린에서는 이 값이 nullable 인지 not null 알 수 없다
     * ==> 플랫폼 타입 : 코틀린이 null 관련 정보를 알 수 없는 타입, 런타임 시 익셉션이 날 수 있다.
     *
     */



