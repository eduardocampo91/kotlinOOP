package Corporation

import Assistance
import java.io.File

class Accountant(id: Int, name: String, age: Int): Worker(id = id, name = name, age = age, position = Position.ACCOUNTANT), Cleaner, Supplier {
    val items = mutableListOf<ProductCard>()
    private val fileProducts = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

    var doWork = true

    override fun clean() {
        println("Im cleaning my desk")
    }

    override fun buyThings() {
        println("Im buying accountant things")
    }
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
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary() {
        println("Enter id of employee to change salary: ")
        val id = readLine()!!.toInt()
        println("Enter new salary: ")
        val salary = readLine()!!.toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees) {
            if(employee.id == id) {
                employee.salary = salary
            }
            saveWorkerToFile(employee)
        }
    }

    private fun registerEmployee() {
        val positions = Position.values()
        println("Chose position - ")
        for ((index, position) in positions.withIndex()) {
            println("$index - ${position.title}")
            if (index < positions.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val positionIndex = readLine()!!.toInt()
        val position =positions[positionIndex]

        println("Enter id: ")
        val id = readLine()!!.toInt()

        println("Enter name: ")
        val name = readLine()!!.toString()

        println("Enter age: ")
        val age = readLine()!!.toInt()

        println("Enter salary: ")
        val salary = readLine()!!.toInt()

        val worker = when(position) {
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.ASSISTANT -> Assistance(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        worker.salary = salary
        saveWorkerToFile(worker)
    }

    private fun fireEmployee() {
        println("Enter id of employee to fire: ")
        val id = readLine()!!.toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees) {
            if(employee.id != id) {
                saveWorkerToFile(employee)
            }
        }
    }

    private fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees) {
            employee.printWorker()
        }
    }

    fun loadAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for(employee in employeesAsText) {
            val properties = employee.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when(position) {
                Position.DIRECTOR -> Director(id, name, age)
                Position.ACCOUNTANT -> Accountant(id, name, age)
                Position.ASSISTANT -> Assistance(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
            }
            worker.salary = salary
            employees.add(worker)
        }
        return employees
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
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
            fileProducts.appendText("$calories%")

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
            fileProducts.appendText("$size%")

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
            fileProducts.appendText("$wattage%")

            applianceItem = ApplianceCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), wattage)
            applianceItem.printInfo()
            items.add(applianceItem)

            return
        }
        fileProducts.appendText("$productType \n")
        doWork = false
    }


    private fun enterBasicInfo(): Array<Any> {
        println("Enter product name: ")
        val name = readLine()!!.toString()
        fileProducts.appendText("$name%")
        println("Enter product Brand: ")
        val brand = readLine()!!.toString()
        fileProducts.appendText("$brand%")
        println("Enter product Price : ")
        val price = readLine()!!.toInt()
        fileProducts.appendText("$price%")

        return arrayOf<Any>(name, brand, price)
    }

    private fun showAllItems () {
       val cards = loadAllCards()
//        for (card in cards) {
//            card.printInfo()
//        }
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

        private fun registerItemEnum() {
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

        print("Enter product brand: ")
        val productBrand = readLine()!!.toString()

        print("Enter product price: ")
        val productPrice = readLine()!!.toInt()

        val card = when(productType) {
            ProductType.FOOD ->  {
                println("Enter food item calories: ")
                val calories = readLine()!!.toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    calories = calories
                )
            }
            ProductType.APPLIANCE -> {
                println("Enter the wattage: ")
                val wattage = readLine()!!.toFloat()

                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }
            ProductType.SHOE -> {
                println("Enter shoe item size: ")
                val size = readLine()!!.toInt()

                ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
            ProductType.MUSICAL_INSTRUMENTS -> {

            }
        }
            saveProductCardToFile(card as ProductCard)
    }

    private fun removeProductCard() {
        val cards = loadAllCards()
        println("Enter name of card for removing: ")
        val name = readLine()!!.toString()
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

    fun saveProductCardToFile(productCard: ProductCard) {
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
}