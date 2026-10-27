package Profile

fun main() {
    val inputName: String = "name please:"
    println(inputName)
    val johnname = readLine()!!.toString()

    println("Input lastname: ")
    val johnLastName = readLine().toString()

    println("Input age: ")
    val johnage = readLine()!!.toInt()

    println("Input height")
    val johnheight = readLine()!!.toInt()

    println("Input weight")
    val johnweight = readLine()!!.toInt()

    val john: Person = Person(johnname, johnLastName, johnheight, johnweight)
    john.age = johnage
    println("Name: ${john.name} Lastname: ${john.lastName} \nAge: ${john.age} \nHeight: ${john.height} \nWeight: ${john.weight}")


    val inputName2: String = "name please:"
    println(inputName2)
    val Nickname = readLine()!!.toString()
    println("Input lastname: ")
    val nickLastName = readLine().toString()
    println("Input age: ")
    val Nickage = readLine()!!.toInt()
    println("Input height")
    val Nickheight = readLine()!!.toInt()
    println("Input weight")
    val Nickweight = readLine()!!.toInt()
    val Nick: Person = Person(Nickname, nickLastName, Nickweight, Nickheight)
    Nick.age = Nickage
    println("Name: ${Nick.name} Lastname: ${Nick.lastName} \nAge: ${Nick.age} \nHeight: ${Nick.height} \nWeight: ${Nick.weight}")

    john.sayHi()
    println(john.fullName)
    Nick.sayHi()

//    john.run()
//    Nick.run()


    // using init and printinfo methods
    val usagi: Person = Person("Usagi", "Kinomoto",175, 50)
    usagi.age = 15
    usagi.age = 14
    // usagi.init("Usagi", 15, 175, 50)
    usagi.sayHi()
    usagi.printInfo()
}