package Corporation

abstract class Worker(val id: Int, val name: String, val age: Int = 0, private var salary: Int = 15000, val position: Position) {

    fun setSalary(salary: Int) {
        if(salary < this.salary) {
            println("Salary should be greater than 15000")
        } else {
            this.salary = salary
        }
    }

    fun getSalary(): Int {
        return this.salary
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