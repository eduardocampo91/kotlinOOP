class Rectangle(val width: Int = 0, val height: Int = 0) {
//    val width: Int
//    val height: Int

    constructor(): this(0)

//    constructor(width: Int, height: Int) {
//        this.width = width
//        this.height = height
//    }

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