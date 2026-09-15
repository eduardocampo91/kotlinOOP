package Corporation

class Accountant(name: String, age: Int): Worker(name = name, age = age) {

    override fun work() {
        println("Enter the operation code. 0 - exit, 1 - register new item")
        val code = readLine()!!.toInt()
        if (code == 0 || code != 1) {
            return
        }

        println("Enter a product type: 0 - food, 1 - shoe, 2 - appliance")
        val itemCode = readLine()!!.toInt()
        var foodItem: FoodCard
        if (itemCode == 0) {
            //food

            println("Enter food item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product calories : ")
            val calories = readLine()!!.toInt()

            foodItem = FoodCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), calories)
            foodItem.printInfo()
            return
        }

        var shoeItem: ShoeCard
        if (itemCode == 1) {
            //shoe

            println("Enter shoe item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product size : ")
            val size = readLine()!!.toInt()

            shoeItem = ShoeCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), size)
            shoeItem.printInfo()
            return
        }

        var applianceItem: ApplianceCard
        if (itemCode == 2) {
            //appliance

            println("Enter appliance item information: ")

            val basicInfo = enterBasicInfo()
            println("Enter product wattage : ")
            val wattage = readLine()!!.toFloat()

            applianceItem = ApplianceCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), wattage)
            applianceItem.printInfo()
            return
        }
    }

    fun enterBasicInfo(): Array<Any> {
        println("Enter product name: ")
        val name = readLine()!!.toString()
        println("Enter product Brand: ")
        val brand = readLine()!!.toString()
        println("Enter product Price : ")
        val price = readLine()!!.toInt()

        return arrayOf<Any>(name, brand, price)
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
}