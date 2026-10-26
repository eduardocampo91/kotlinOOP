package Corporation

abstract class Worker(val id: Int, val name: String, val age: Int = 0,val position: Position) {

    var salary: Int = 15000
        set(value) {
            if (value < field) {
                println("Salary should be greater than 15000")
            } else {
                field = value
            }
        }
//        get() {
//            return field
//        }
//    fun setSalary(salary: Int) {
//        if(salary < this.salary) {
//            println("Salary should be greater than 15000")
//        } else {
//            this.salary = salary
//        }
//    }
//
//    fun getSalary(): Int {
//        return this.salary
//    }

    abstract fun work ()

    fun printWorker() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }
}