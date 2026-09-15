package Corporation

class ApplianceCard (name: String, brand: String, price: Int, val wattage: Float): ProductCard(name = name, brand = brand, price = price) {
    override fun printInfo() {
        super.printInfo()
        // println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Wattage = $wattage")
        println("Wattage = $wattage")
    }

}