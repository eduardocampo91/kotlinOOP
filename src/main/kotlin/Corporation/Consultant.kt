package Corporation

import kotlin.random.Random

data class Consultant(override val id: Int, override val name: String, override val age: Int = 0, override val salary: Int): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.CONSULTANT
), Cleaner {

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

    override fun copy(salary: Int, age: Int): Consultant {
        return Consultant(this.id, this.name, age, salary)
    }
}