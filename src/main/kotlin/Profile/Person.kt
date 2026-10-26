package Profile

class Person {
    val name: String
    val height: Int
    val weight: Int

    constructor(name: String, height: Int, weight: Int) {
        this.name =name
        this.height = height
        this.weight = weight
    }
     var age: Int = 0
        set(value) {
            if (value > field) {
                field = value
            } else {
                println("Age value can only increase")
            }
        }
        get() {
            println("Getter for the age")
            return field
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