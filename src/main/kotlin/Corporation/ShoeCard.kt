package Corporation


data class ShoeCard (override val name: String, override val brand: String, override val price: Int, val size: Int): ProductCard(name = name, brand = brand, price = price, productType = ProductType.SHOE) {
        override fun printInfo() {
                println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Product type = ${productType.title} Size = $size\n")
        }

}