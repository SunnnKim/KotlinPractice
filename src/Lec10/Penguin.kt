package Lec10

class Penguin(
    species: String,
) : Animal(species, 2) , Swimmable, Flyable{ // 추상메소드, 인터페이스 모두 : 으로 상속받음

    private val wingCount = 2
    // 구현되지 않은 Swimmable 인터페이스의 backing field 를 구현한다.
    override val swimmnAbility: Int
        get() = 2

    override fun move() {
        println("펭귄이 움직임")
    }

    /** getter override
     * 추상클래스에서 이미 정의된 함수를 오버라이드 해야하는 경우에는 다음과 같은 순서로 진행한다.
     *
     * 1. 프로퍼티에 override 키워드를 붙인다.
     * 2. custom getter 를 만들고 원하는 로직을 넣는다
     * *** 3. 오버라이드 하려고 하는 필드가 상위클래스에서 open 으로 지정된 변수여야 오버라이드가 가능하다
     * 4. 상위클래스에 접근하는 키워드는 super
     * 5. 자바와 코틀린 모두 추상 클래스는 인스턴스화 할 수 없다
     */

    override val legCount: Int
        get() = super.legCount + this.wingCount

    /**
     * 인터페이스상속
     * 인터페이스 상속 시 super<인터페이스명>.함수명() 형식으로 되어있음
     */
    override fun act() {
        super<Swimmable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        // 인터페이스 추상메소드 구현
    }
}

