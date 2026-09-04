package Profile

fun main() {
    val inputName: String = "name please:"
    println(inputName)
    val johnname = readLine()!!.toString()
    println("Input age: ")
    val johnage = readLine()!!.toInt()
    println("Input height")
    val johnheight = readLine()!!.toInt()
    println("Input weight")
    val johnweight = readLine()!!.toInt()
    val john: Person = Person(johnname, johnage, johnheight, johnweight)
    println("Name: ${john.name} \nAge: ${john.age} \nHeight: ${john.height} \nWeight: ${john.weight}")


    val inputName2: String = "name please:"
    println(inputName2)
    val Nickname = readLine()!!.toString()
    println("Input age: ")
    val Nickage = readLine()!!.toInt()
    println("Input height")
    val Nickheight = readLine()!!.toInt()
    println("Input weight")
    val Nickweight = readLine()!!.toInt()
    val Nick: Person = Person(Nickname, Nickage, Nickweight, Nickheight)
    println("Name: ${Nick.name} \nAge: ${Nick.age} \nHeight: ${Nick.height} \nWeight: ${Nick.weight}")

    john.sayHi()
    Nick.sayHi()

//    john.run()
//    Nick.run()


    // using init and printinfo methods
    val usagi: Person = Person("Usagi", 15, 175, 50)
    // usagi.init("Usagi", 15, 175, 50)
    usagi.sayHi()
    usagi.printInfo()
}