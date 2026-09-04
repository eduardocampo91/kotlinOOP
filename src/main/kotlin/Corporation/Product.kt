package Corporation

class Product(val name: String = "b", val brand: String = "bb", val size: Float = 1f, val price: Int = 22) {

//    constructor(name: String = "b", brand: String = "bb", size: Float = 1f, price:Int = 22) {
//        this.name = name
//        this.brand = brand
//        this.size = size
//        this.price = price
//    }

    //    fun init(name: String = "b", brand: String = "bb", size: Float = 1f, price:Int = 22) {
//        this.name = name
//        this.brand = brand
//        this.size = size
//        this.price = price
//    }

    fun printInfo() {
        println("Name: ${this.name} Brand: ${this.brand} Size: ${this.size} Price: ${this.price}")
    }
}