package Corporation

import Assistance
import java.io.File

class Accountant(id: Int,
                 name: String,
                 age: Int,
                 salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.ACCOUNTANT
), Cleaner, Supplier {

    val items = mutableListOf<ProductCard>()
    private val workersRepository = WorkersRepository
    private val productCardsRepository = ProductCardsRepository

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
                    workersRepository.saveChanges()
                    productCardsRepository.savingData()
                    doWork = false
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerItemEnum()
                OperationCode.SHOW_ALL_ITEMS -> {
                    showAllItems()
                }
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee(id)
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
        workersRepository.changeSalary(id, salary)
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
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistance(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        //worker.setSalary(salary)
        workersRepository.registerNewEmployee(worker)
    }

    fun fireEmployee(id: Int) {
        println("Enter id of employee to fire: ")
        val id = readLine()!!.toInt()
        workersRepository.fireEmployee(id)
    }

    private fun showAllEmployees() {
        val employees = workersRepository.employees
        for (employee in employees) {
            employee.printWorker()
        }
    }

//    fun registerNewItem() {
//        val ProductTypes = ProductType.values()
//        var productType = ProductTypes[0]
//
//        println("Enter a product type: 0 - food, 1 - shoe, 2 - appliance")
//        val itemCode = readLine()!!.toInt()
//        var foodItem: FoodCard
//        if (itemCode == 0) {
//            //food
//            productType = ProductTypes[itemCode]
//
//            println("Enter food item information: ")
//
//            val basicInfo = enterBasicInfo()
//            println("Enter product calories : ")
//            val calories = readLine()!!.toInt()
//            fileProducts.appendText("$calories%")
//
//            foodItem = FoodCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), calories)
//            foodItem.printInfo()
//            items.add(foodItem)
//            return
//        }
//
//        var shoeItem: ShoeCard
//        if (itemCode == 1) {
//            //shoe
//            productType = ProductTypes[itemCode]
//
//            println("Enter shoe item information: ")
//
//            val basicInfo = enterBasicInfo()
//            println("Enter product size : ")
//            val size = readLine()!!.toInt()
//            fileProducts.appendText("$size%")
//
//            shoeItem = ShoeCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), size)
//            shoeItem.printInfo()
//            items.add(shoeItem)
//            return
//        }
//
//        var applianceItem: ApplianceCard
//        if (itemCode == 2) {
//            //appliance
//            productType = ProductTypes[itemCode]
//
//            println("Enter appliance item information: ")
//
//            val basicInfo = enterBasicInfo()
//            println("Enter product wattage : ")
//            val wattage = readLine()!!.toFloat()
//            fileProducts.appendText("$wattage%")
//
//            applianceItem = ApplianceCard(name = (basicInfo[0] as String), brand = (basicInfo[1] as String), price = (basicInfo[2] as Int), wattage)
//            applianceItem.printInfo()
//            items.add(applianceItem)
//
//            return
//        }
//        fileProducts.appendText("$productType \n")
//        doWork = false
//    }


//    private fun enterBasicInfo(): Array<Any> {
//        println("Enter product name: ")
//        val name = readLine()!!.toString()
//        fileProducts.appendText("$name%")
//        println("Enter product Brand: ")
//        val brand = readLine()!!.toString()
//        fileProducts.appendText("$brand%")
//        println("Enter product Price : ")
//        val price = readLine()!!.toInt()
//        fileProducts.appendText("$price%")
//
//        return arrayOf<Any>(name, brand, price)
//    }

    private fun showAllItems () {
       val cards = productCardsRepository.productCards
        for (card in cards) {
            card.printInfo()
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
            productCardsRepository.registerItemEnum(card as ProductCard)
    }

    private fun removeProductCard() {
        println("Enter name of card for removing: ")
        val name = readLine()!!.toString()
        productCardsRepository.removeProductCard(name)
    }
}