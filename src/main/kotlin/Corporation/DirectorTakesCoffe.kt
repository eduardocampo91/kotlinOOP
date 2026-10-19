import Corporation.Consultant
import Corporation.Director

fun main() {
    val director = Director(69, "Chris", 40)
    val assistant = Assistance(47, "Atlas")
    director.takeCoffee(assistant)
    director.takeCoffee(assistant, "chai")


    val consultant = Consultant(66, "Amy")
    // consultant.serveCustomers()
    director.getConsultantToWork(consultant)
}