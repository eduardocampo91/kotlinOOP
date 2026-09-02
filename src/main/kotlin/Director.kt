class Director(val name: String, val age: Int) {
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
        println("Consultant ${consultant.name} served $count clients")

    }
}