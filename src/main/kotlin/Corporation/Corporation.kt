package Corporation

import Assistance

fun main() {
//    val assistance = Assistance()
//    assistance.bringCoffee(5, "espresso")

    println("Enter name: ")
    val name = readLine().toString()

    println("Enter brand: ")
    val brand = readLine().toString()

    println("Enter size: ")
    val size = readLine()!!.toFloat()

    println("Enter price: ")
    val price = readLine()!!.toInt()

    val productCard = Product(name, brand, size, price)
//
//    productCard.name = name
//    productCard.brand = brand
//    productCard.size = size
//    productCard.price = price

//    println("Name: ${productCard.name} Brand: ${productCard.brand} Size: ${productCard.size} Price: ${productCard.price}")

    productCard.printInfo()

    val product2 = Product("SDVV", "hp", 2.3f, 500)
    //product2.init()
    // product2.init(name, brand, size, price)
    product2.printInfo()

    println("///////////////////////////////")
    val director: Worker = Director("Bob", 50)
    val consultant: Worker = Consultant("Rachel", 26)

    // upcasting when an object or an instance of any class is stored in a variable of its parent type, it can
    // access the parent properties and methods but not its own
    val assistant: Worker = Assistance("Ken", 154)
    // assistant.bringCoffee()

    // downcasting is when an instance of a class is cast back to the child type
    (assistant as Assistance).bringCoffee()

    (director as Director).getConsultantToWork(consultant as Consultant)
}