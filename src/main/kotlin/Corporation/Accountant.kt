package Corporation

import java.io.File

class Accountant(name: String, age: Int): Worker(name = name, age = age) {
    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    var doWork = true
    override fun work() {
        val operationCodes = OperationCode.values()
//        println("Enter the operation code. 0 - exit, 1 - register new item")
//        val code = readLine()!!.toInt()
//        if (code == 0 || code != 1) {
//            return
//        }
        println("Enter the operation code: ")
        while(doWork) {
        for ((index, code) in operationCodes.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationCodes.size - 1) {
                print(", ")
            } else {
                println(": ")
            }
        }
            val operationIndex = readLine()!!.toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> {
                    doWork = false
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerItemEnum()
                OperationCode.SHOW_ALL_ITEMS -> {
                    showAllItems()
                    doWork = false
                }
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun registerNewItem() {
        val ProductTypes = ProductType.values()
        var productType = ProductTypes[0]

        println("Enter a product type: 0 - food, 1 - shoe, 2 - appliance")
        val itemCode = readLine()!!.toInt()
        var foodItem: FoodCard
        if (itemCode == 0) {
            //food
            productType = ProductTypes[itemCode]

            println("Enter food item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product calories : ")
            val calories = readLine()!!.toInt()
            file.appendText("$calories%")

            foodItem = FoodCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), calories)
            foodItem.printInfo()
            items.add(foodItem)
            return
        }

        var shoeItem: ShoeCard
        if (itemCode == 1) {
            //shoe
            productType = ProductTypes[itemCode]

            println("Enter shoe item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product size : ")
            val size = readLine()!!.toInt()
            file.appendText("$size%")

            shoeItem = ShoeCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), size)
            shoeItem.printInfo()
            items.add(shoeItem)
            return
        }

        var applianceItem: ApplianceCard
        if (itemCode == 2) {
            //appliance
            productType = ProductTypes[itemCode]

            println("Enter appliance item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product wattage : ")
            val wattage = readLine()!!.toFloat()
            file.appendText("$wattage%")

            applianceItem = ApplianceCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), wattage)
            applianceItem.printInfo()
            items.add(applianceItem)

            return
        }
        file.appendText("$productType \n")
        doWork = false
    }


    fun enterBasicInfo(): Array<Any> {
        println("Enter product name: ")
        val name = readLine()!!.toString()
        file.appendText("$name%")
        println("Enter product Brand: ")
        val brand = readLine()!!.toString()
        file.appendText("$brand%")
        println("Enter product Price : ")
        val price = readLine()!!.toInt()
        file.appendText("$price%")

        return arrayOf<Any>(name, brand, price)
    }

    fun showAllItems () {
        val valuesText = file.readText().trim()
        if (valuesText.isEmpty()) {
            return
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
            }
    }

    // teach solution
//    override fun work() {
//        while (true) {
//            println("Enter the operation code. 0 - exit, 1 - register new item")
//            val operation = readLine()!!.toInt()
//            when(operation) {
//                0 -> break
//                1 -> registerItem()
//            }
//        }
//    }
//
//    fun registerItem() {
//        println("Enter a product type: 0 - food, 1 - shoe, 2 - appliance")
//        val productType = readLine()!!.toInt()
//
//        print("Enter product name: ")
//        val productName = readLine()!!.toString()
//
//        print("Enter product brand: ")
//        val productBrand = readLine()!!.toString()
//
//        print("Enter product price: ")
//        val productPrice = readLine()!!.toInt()
//
//        var cardItem = ProductCard("", "", 0)
//
//        when(productType) {
//            0 -> {
//                println("Enter food item calories: ")
//                val calories = readLine()!!.toInt()
//                cardItem = FoodCard(
//                    name = productName,
//                    brand = productBrand,
//                    price = productPrice,
//                    calories = calories
//                )
//            }
//            1 -> {
//                println("Enter shoe item size: ")
//                val size = readLine()!!.toInt()
//                cardItem = ShoeCard(
//                    name = productName,
//                    brand = productBrand,
//                    price = productPrice,
//                    size = size
//                )
//            }
//            2 -> {
//                println("Enter shoe item size: ")
//                val wattage = readLine()!!.toFloat()
//                cardItem = ApplianceCard(
//                    name = productName,
//                    brand = productBrand,
//                    price = productPrice,
//                    wattage = wattage
//                )
//            }
//        }
//        cardItem.printInfo()
//    }

        fun registerItemEnum() {
            val ProductTypes = ProductType.values()
//        println("Enter a product type: 0 - ${ProductTypes[0].title}, 1 - ${ProductTypes[1].title}, 2 - ${ProductTypes[2].title}")
            println("Enter a product type: ")

            for ((index, type) in ProductTypes.withIndex()) {
                print("$index - ${type.title}")
                if (index < ProductTypes.size - 1) {
                    print(", ")
                } else {
                    println(": ")
                }
            }
        val productTypeIndex = readLine()!!.toInt()
            val productType = ProductTypes[productTypeIndex]

        print("Enter product name: ")
        val productName = readLine()!!.toString()
            file.appendText("$productName%")

        print("Enter product brand: ")
        val productBrand = readLine()!!.toString()
            file.appendText("$productBrand%")

        print("Enter product price: ")
        val productPrice = readLine()!!.toInt()
            file.appendText("$productPrice%")

        var cardItem = ProductCard("", "", 0)

        when(productType) {
            ProductType.FOOD ->  {
                println("Enter food item calories: ")
                val calories = readLine()!!.toInt()
                file.appendText("$calories%")

                cardItem = FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    calories = calories
                )
            }
            ProductType.APPLIANCE -> {
                println("Enter the wattage: ")
                val wattage = readLine()!!.toFloat()
                file.appendText("$wattage%")

                cardItem = ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }
            ProductType.SHOE -> {
                println("Enter shoe item size: ")
                val size = readLine()!!.toInt()
                file.appendText("$size%")

                cardItem = ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
            ProductType.MUSICAL_INSTRUMENTS -> {

            }
        }
            file.appendText("$productType \n")
            cardItem.printInfo()
    }

    fun removeProductCard() {
        val cards = loadAllCards()
        println("Enter name of card for removing: ")
        val name = readLine()!!.toString()
        for ((index, card) in cards.withIndex()) {
            if (card.name == name) {
                cards.removeAt(index)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()

        val valuesText = file.readText().trim()
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

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%")
        file.appendText("${productCard.brand}%")
        file.appendText("${productCard.price}%")

        when (productCard) {
            is FoodCard -> {
                val calories = productCard.calories
                file.appendText("$calories%${ProductType.FOOD}\n")
            }
            is ShoeCard -> {
                val size = productCard.size
                file.appendText("$size%${ProductType.SHOE}\n")
            }
            is ApplianceCard -> {
                val wattage = productCard.wattage
                file.appendText("$wattage%${ProductType.APPLIANCE}\n")
            }
        }
    }
}