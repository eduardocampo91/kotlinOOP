package Profile

data class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
) {
//
//
//    constructor(name: String, height: Int, weight: Int) {
//        this.name =name
//        this.height = height
//        this.weight = weight
//    }

    val fullName: String
        get() = "$name $lastName"

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

//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (lastName != other.lastName) return false
//        if (height != other.height) return false
//        if (weight != other.weight) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + lastName.hashCode()
//        result = 31 * result + height
//        result = 31 * result + weight
//        return result
//    }
//
//    override fun toString(): String {
//        return "Person(name='$name', lastName='$lastName', height=$height, weight=$weight, fullName='$fullName', age=$age)"
//    }

//    fun copy(
//        name: String = this.name,
//        lastName: String = this.lastName,
//        height: Int = this.height,
//        weight: Int = this.weight) = Person(name, lastName, height, weight)

}