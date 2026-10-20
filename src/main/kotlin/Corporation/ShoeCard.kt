package Corporation


class ShoeCard (name: String, brand: String, price: Int, val size: Int): ProductCard(name = name, brand = brand, price = price, productType = ProductType.SHOE) {
        override fun printInfo() {
                println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Product type = ${productType.title} Size = $size\n")
        }

}