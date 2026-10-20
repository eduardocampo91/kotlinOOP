package Corporation

abstract class Worker(val id: Int, val name: String, val age: Int = 0,val position: Position) {
    abstract fun work ()

    fun printWorker() {
        println("Id: $id Name: $name Age: $age Position: $position")
    }
}