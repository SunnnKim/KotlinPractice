package Lec12

fun main(){
    println(Singleton.a)
}
// 싱글톤
object Singleton {

    var a: Int = 0
}