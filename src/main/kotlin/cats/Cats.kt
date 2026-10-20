package cats

class Cats(val name: String): CatsFamily() {
    fun playWithMouse() {
        println("Playing with mouse!")
    }

    override fun eat() {
        println("I eat tuna")
    }
}