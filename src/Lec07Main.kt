import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.Buffer

/***
 * 7강. 코틀린에서 예외를 다루는 방법
 *
 */

fun main(){
}
/** 1. try catch
 * - 문법적으로 자바와 동일함
 * - 다만 기본구문이 달라 타입을 뒤에 명시해야함
 * - 문법적으로는 자바와 코틀린이 동일하지만
 * - 코틀린에서는 try catch가 expression 이기 떄문에
 * - 값은 반환하거나(return), 구문 자체를 값에 할당하는 것이 가능
 *
private int parseIntOrThrow(@NotNull String str){
    try{
        return Integer.parseInt(str);
    }catch (NumberFormatException e){
        throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다."));
    }
}*/
fun parseIntOrThrow(str:String): Int {
    try {
        return str.toInt()
    }catch(e: NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다")
    }
}
// 예외발생 시 null을 반환하는 함수
// return 1번만해도 동작하도록 되어있음
fun parseIntOrThrowV2(str: String): Int?{
    return try{
        str.toInt()
    }catch (e: NumberFormatException){
        null
    }
}

// 3. try catch final도 똑같음

// 4. readFile
/*
public void readFile(){ // IOException 필수
    File currentFile = new File(".");
    File file = new File(currentFile.getAbsolutePath()) + "/a.txt");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    System.out.println(reader.readLine());
    reader.close();
}*/
/**
 * # Kotlin에서는 throws가 없다(!)
 * - checked / unchecked Exception 구분이 없고
 * - 모두 unchecked Exception 로 간주
 * ---> 빨간줄이 나지 않음
 */
class FilePrint {
    fun main(){

    }
    fun readFile(){
        val currentFile = File(".");
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.read())
        reader.close()
    }
}

/** try with resources
 * - try 를 사용하면 괄호안에 외부 자원을 만들어주고
 * - try구문이 종료되면 자동으로 외부자원을 닫아준다 (JDK7에서 추가)
 * - 코틀린에는 따로 try with resources 가 사라지고 use를 사용!!!! (inline 확장함수)
 * - 확장함수를 사용해서 리소스를 만들고 사용할 수 있다.
 * - use 함수는 추후에 자세히 설명할 예정
 */

fun readFile(path: String){
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.read())
    }
}