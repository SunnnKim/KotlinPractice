package Lec10

/**
 * 10강 추상클래스 샘플
 */
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
    // open : 추상프로퍼티가 아니라면 오버라이드를 하기 위해서 반드시 open키워드를 붙여야한다.
) {
    abstract fun move()
}