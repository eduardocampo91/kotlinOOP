import Corporation.Consultant
import Corporation.Director

fun main() {
    val director = Director(69, "Chris", 40, 654115)
    val assistant = Assistance(47, "Atlas",54, 6545)
    director.takeCoffee(assistant)
    director.takeCoffee(assistant, "chai")


    val consultant = Consultant(66, "Amy", 54, 45783)
    // consultant.serveCustomers()
    director.getConsultantToWork(consultant)
}