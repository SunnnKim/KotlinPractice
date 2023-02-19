package Lec10

interface Swimmable {
    fun act(){
        println("어푸어푸")
        println(swimmnAbility) // 구현되지 않은 필드이지만 상속 후 구현받는다는 가정하에 사용가능하다
    }
    // getter에 대한 추상메소드를 만드는 거라서 가능하다
    val swimmnAbility: Int // backing field 없는 프로퍼티를 만들 수 있다
       get() = 10 // default 값
}