package Corporation

import Assistance

class Director(id: Int, name: String, age: Int, salary: Int): Worker(id = id, name = name, age =age, salary = salary, position = Position.DIRECTOR), Supplier {
    fun takeCoffee(assistant: Assistance, drinkName: String = ""){
        if (drinkName == "") {
            assistant.bringCoffee()
            println("Thank you ${assistant.name}, the espresso was very tasty")
        } else {
            val drink = assistant.bringCoffee(typeCoffee = drinkName)
            println("Thank you ${assistant.name}, the $drink was very tasty")
        }

    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("Corporation.Consultant ${consultant.name} served $count clients")

    }

    override fun work() {
        println("I drink coffee")
    }

    override fun buyThings() {
        println("Im buying director things")
    }
}