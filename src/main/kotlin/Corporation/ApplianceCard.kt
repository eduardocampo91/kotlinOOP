package Corporation

class ApplianceCard (name: String, brand: String, price: Int, val wattage: Float): ProductCard(name = name, brand = brand, price = price, productType = ProductType.APPLIANCE) {
    override fun printInfo() {
        // super.printInfo() // this wont work since productCard is now abstract
        println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Product type = ${productType.title} Wattage = $wattage\n")
        // println("Wattage = $wattage")
    }

}