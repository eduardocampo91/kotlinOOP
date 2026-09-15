package Corporation

open class Worker(val name: String, val age: Int = 0) {
    open fun work () {
        println("Working")
    }
}