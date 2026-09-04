package Corporation

import Assistance

class Director(name: String, age: Int): Worker(name = name, age =age) {
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
}