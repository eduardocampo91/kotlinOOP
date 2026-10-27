import Corporation.Cleaner
import Corporation.Position
import Corporation.Supplier
import Corporation.Worker

class Assistance(id: Int, name: String, age: Int = 0, salary: Int): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.ASSISTANT
),
    Cleaner, Supplier {
    fun bringCoffee(count: Int = 1, typeCoffee: String = "espresso"): String {
        println("Get up")
        println("Go to coffee machine")
        repeat(count) {
            println("Press the \"$typeCoffee\" button")
            println("Wait for the $typeCoffee to be prepared")
            println("Take coffee")
            println("Bring coffee to director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return typeCoffee
    }

    override fun work() {
        println("I am answering the phone")
    }

    override fun clean() {
        println("I am cleaning too")
    }

    override fun buyThings() {
        println("Im buying assistant things")
    }
}