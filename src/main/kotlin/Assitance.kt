class Assistance(val name: String) {
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
}