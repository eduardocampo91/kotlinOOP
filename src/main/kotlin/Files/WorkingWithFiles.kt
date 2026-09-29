package Files

import Corporation.OperationCode
import java.io.File

fun main() {
    val file = File("test.txt")
    file.writeText("Hi bb! ")
    file.appendText("bye")

    val todoList = File("todoList.txt")

//    var continueList = true
//    var todoItem = ""
//    while (continueList) {
//        println("Would you like to add a new todo item? yes - 1 | no - 0")
//        val code = readLine()!!.toInt()
//        if (code != 0) {
//            println("Type your todo")
//            todoItem = readLine()!!.toString()
//            todoList.appendText("$todoItem \n")
//        } else {
//            continueList = false
//        }
//    }
//
//    val todoContentDis = todoList.readText()
//    println(todoContentDis)


    var doWork = true
    val operationCodes = OperationCodeFiles.values()
    while(doWork) {
        println("Enter the operation code: ")
        for ((index, code) in operationCodes.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationCodes.size - 1) {
                print(", ")
            } else {
                println(": ")
            }
        }
        val operationIndex = readLine()!!.toInt()
        val operationCode = operationCodes[operationIndex]
        when (operationCode) {
            OperationCodeFiles.SHUT_DOWN -> {
                doWork = false
                break
            }
            OperationCodeFiles.NEW_TASK -> {
                println("Type your todo")
                val todoItem = readLine()!!.toString()
                todoList.appendText("$todoItem \n")
            }
            OperationCodeFiles.DISPLAY_LIST -> {
//                val todoContentDis = todoList.readText()
//                println(todoContentDis)
                val splitedList = todoList.readText().trim().split("\n")

                for ((index, item) in splitedList.withIndex()) {
                    println("${index + 1} - $item")
                }
            }
        }
    }



}