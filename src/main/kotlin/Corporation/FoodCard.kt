package Corporation

class FoodCard (name: String, brand: String, price: Int, val calories: Int): ProductCard(name = name, brand = brand, price = price, productType = ProductType.FOOD) {
    override fun printInfo() {
        println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Product type = ${productType.title} Calories = $calories\n")
    }

}