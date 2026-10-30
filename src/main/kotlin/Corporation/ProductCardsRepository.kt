package Corporation

import java.io.File
import java.lang.StringBuilder

object ProductCardsRepository {
    private val fileProducts = File("product_cards.txt")
    val productCards = loadAllCards()

    fun registerItemEnum(productCard: ProductCard) {
        productCards.add(productCard)
    }

    private fun loadAllCards(): MutableList<ProductCard> {
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

    fun savingData() {
        val content = StringBuilder()
        for (productCard in productCards) {
            content.append("${productCard.name}%")
            content.append("${productCard.brand}%")
            content.append("${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    val calories = productCard.calories
                    content.append("$calories%")
                }
                is ShoeCard -> {
                    val size = productCard.size
                    content.append("$size%")
                }
                is ApplianceCard -> {
                    val wattage = productCard.wattage
                    content.append("$wattage%")
                }
            }
            content.append("${productCard.productType}\n")
        }
        fileProducts.writeText(content.toString())
    }

    fun removeProductCard(name: String) {
        for ((index, card) in productCards.withIndex()) {
            if (card.name == name) {
                productCards.removeAt(index)
                break
            }
        }
        fileProducts.writeText("")
//        for (card in productCards) {
//            saveProductCardToFile(card)
//        }
    }
}