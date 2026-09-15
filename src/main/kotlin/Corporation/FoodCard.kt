package Corporation

class FoodCard (name: String, brand: String, price: Int, val calories: Int): ProductCard(name = name, brand = brand, price = price) {
    override fun printInfo() {
        super.printInfo()
        // println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Calories = $calories")
        println("Calories = $calories")

    }

}