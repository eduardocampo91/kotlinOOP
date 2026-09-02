import kotlin.random.Random

class Consultant(val name: String, val age: Int = 0) {

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