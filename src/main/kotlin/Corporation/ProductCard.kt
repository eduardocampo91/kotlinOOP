package Corporation

open class ProductCard(val name: String, val brand: String, val price: Int, val productType: ProductType) {
    open fun printInfo() {
        print("Name: ${this.name}, Brand: ${this.brand}, Price: ${this.price}, Product Type: ${this.productType.title}")
    }
}