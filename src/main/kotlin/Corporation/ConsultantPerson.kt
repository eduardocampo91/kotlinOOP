import Corporation.Consultant

fun main() {
    val person = Consultant("Kathe")
    person.sayHello()

    val person2 = Consultant("Bebe", 29)
    person2.sayHello()
}