package Lec11

//protected var a = 10 -> 파일 최상단에서는 protected 사용불가
internal fun main() {

}

class Cat (
    private var _name: String,
    internal val leg: Int,
    val _color: String
){
    var color = _color
        private set

    var name = _name


}

// 유틸함수
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}
