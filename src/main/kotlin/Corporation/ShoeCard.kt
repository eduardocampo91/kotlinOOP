package Corporation


class ShoeCard (name: String, brand: String, price: Int, val size: Int): ProductCard(name = name, brand = brand, price = price) {
        override fun printInfo() {
                super.printInfo()
                // println("Name: ${this.name} Brand: ${this.brand} Price: ${this.price} Size = ${this.size}")
                println("Size = ${this.size}")

        }

}