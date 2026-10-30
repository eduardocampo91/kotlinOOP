package Corporation

import Assistance
import java.io.File
import java.lang.StringBuilder

object WorkersRepository {
    private val fileWorkers = File("workers.txt")
    val employees = loadAllEmployees()

    fun registerNewEmployee(worker: Worker) {
        employees.add(worker)
    }

//    private fun saveWorkerToFile(worker: Worker) {
//        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.position}\n")
//    }

    private fun loadAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for(employee in employeesAsText) {
            val properties = employee.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when(position) {
                Position.DIRECTOR -> Director(id, name, age, salary)
                Position.ACCOUNTANT -> Accountant(id, name, age, salary)
                Position.ASSISTANT -> Assistance(id, name, age, salary)
                Position.CONSULTANT -> Consultant(id, name, age, salary)
            }
            // worker.setSalary(salary)
            employees.add(worker)
        }
        return employees
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (employee in employees) {
            content.append("${employee.id}%${employee.name}%${employee.age}%${employee.getSalary()}%${employee.position}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    fun fireEmployee(id: Int) {
        for (employee in employees) {
            if(employee.id != id) {
                employees.remove(employee)
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int) {
        for (employee in employees) {
            if(employee.id == id) {
                employee.setSalary(salary)
            }
        }
    }

}