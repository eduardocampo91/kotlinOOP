package Corporation

import kotlin.random.Random

class Consultant(name: String, age: Int = 0): Worker(name = name, age = age) {

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

}