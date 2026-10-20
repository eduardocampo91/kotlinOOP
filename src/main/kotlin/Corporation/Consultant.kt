package Corporation

import kotlin.random.Random

class Consultant(id: Int, name: String, age: Int = 0): Worker(id = id, name = name, age = age,position = Position.CONSULTANT), Cleaner {

    fun sayHello(){
        if (name !== "" && age == 0) {
            println("Hello my name is $name!")
        } else {
            println("Hello my name is $name!, I'm $age years old")
        }
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 100)
        repeat(count) {
            println("The customer is served... ")
        }
        return count
    }

    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("I clean")
    }

}