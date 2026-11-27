package exceptions

import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main () {
//    val a = readLine()!!.toInt()
//    val b = readLine()!!.toInt()
//if (b == 0) {
//    throw ArithmeticException("You cannot divide by 0")
//}
//    println(a/b)
//try {
//    val a = readLine()!!.toInt()
//    val b = readLine()!!.toInt()
//    println(a/b)
//} catch (exception: java.lang.ArithmeticException) {
//        println("You cannot divide by 0")
//    } catch (ex: NumberFormatException) {
//    println("Wrong input")
//    } catch (ex: Throwable) {
//    println("common error")
//}
//    println("done")

    val arr = arrayListOf<Int>(1,2,3)
    try {
        println(arr[4])
    } catch (ex: IndexOutOfBoundsException) {
        println("out of bound")
    }
}