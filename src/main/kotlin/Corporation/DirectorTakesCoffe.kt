import Corporation.Consultant
import Corporation.Director

fun main() {
    val director = Director("Chris", 40)
    val assistant = Assistance("Atlas")
    director.takeCoffee(assistant)
    director.takeCoffee(assistant, "chai")


    val consultant = Consultant("Amy")
    // consultant.serveCustomers()
    director.getConsultantToWork(consultant)
}