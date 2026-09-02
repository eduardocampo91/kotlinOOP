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
}