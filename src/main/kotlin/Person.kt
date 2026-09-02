class Person {
    val name: String
    val age: Int
    val height: Int
    val weight: Int

    constructor(name: String, age: Int, height: Int, weight: Int) {
        this.name =name
        this.age = age
        this.height = height
        this.weight = weight
    }

//    fun init(name: String, age: Int, height: Int, weight: Int) {
//        this.name =name
//        this.age = age
//        this.height = height
//        this.weight = weight
//    }

    fun printInfo () {
        println("Name: $name Age: $age Height: $height Weight: $weight")
    }

    fun sayHi() {
        println("Hello my name is $name")
    }

    fun run () {
        repeat(10) {
            println("running... ")
        }
    }


}