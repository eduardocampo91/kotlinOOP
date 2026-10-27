class Rectangle(var width: Int = 0, var height: Int = 0) {
//    val width: Int
//    val height: Int

    constructor(): this(0)

//    constructor(width: Int, height: Int) {
//        this.width = width
//        this.height = height
//    }

    val area: Int
        get() = width * height

    constructor(size: Int): this(size, size)

    fun draw() {
        repeat(height){
            repeat(width) {
                print("*")
            }
            print("\n")
        }
    }
}