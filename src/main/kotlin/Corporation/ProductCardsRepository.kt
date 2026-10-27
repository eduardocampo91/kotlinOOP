package Corporation

import java.io.File

class ProductCardsRepository {
    private val fileProducts = File("product_cards.txt")

    fun registerItemEnum(productCard: ProductCard) {
        saveProductCardToFile(productCard)
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProducts.appendText("${productCard.name}%")
        fileProducts.appendText("${productCard.brand}%")
        fileProducts.appendText("${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val calories = productCard.calories
                fileProducts.appendText("$calories%")
            }
            is ShoeCard -> {
                val size = productCard.size
                fileProducts.appendText("$size%")
            }
            is ApplianceCard -> {
                val wattage = productCard.wattage
                fileProducts.appendText("$wattage%")
            }
        }
        fileProducts.appendText("${productCard.productType}\n")
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()

        val valuesText = fileProducts.readText().trim()
        if (valuesText.isEmpty()) {
            return cards
        }

        val itemAsStringCard = valuesText.split("\n")
        for (item in itemAsStringCard) {
            val properties = item.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last().trim()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toFloat()
                    ApplianceCard(name, brand, price, wattage)
                }
                ProductType.SHOE -> {
                    val size = properties[3].toInt()
                    ShoeCard(name, brand, price, size)
                }
                ProductType.MUSICAL_INSTRUMENTS -> TODO()
            }
            productCard.printInfo()
            cards.add(productCard)
        }
        return cards
    }

    fun removeProductCard(name: String) {
        val cards = loadAllCards()

        for ((index, card) in cards.withIndex()) {
            if (card.name == name) {
                cards.removeAt(index)
                break
            }
        }
        fileProducts.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }
}