package Lec12

// 익명클래스 구현방법
fun main(){
    moveSomething(object : Movable{
        override fun move() {
            println("let's move")
        }

        override fun fly() {
            println("let's fly")
        }

    })
}

fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}