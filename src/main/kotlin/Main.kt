package org.example

import kotlinx.coroutines.*
import org.example.Student
import org.example.Group

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun fetchGradesFromServer(): List<Int> {
    delay(2000)
    return listOf(85, 90, 95, 88, 92)
}

fun main() = runBlocking {
    // Create students using different constructors
    val student1 = Student("Ivan Petrenko")
    student1.age = 20
    student1.updateGrades(listOf(85, 90, 95))

    val student2 = Student(
        _name = "Olena Kovalenko",  // Using named argument
        _age = 17,
        _grades = listOf(88, 92, 95)
    )

    println("\nInitial student information:")
    println(student1)
    println(student2)

    // Demonstrate operator overloading
    println("\nCombined grades of both students:")
    val combinedGrades = student1 + student2
    println(combinedGrades)

    println("\nMultiplied grades of student1 by 2:")
    val multipliedGrades = student1 * 2
    println(multipliedGrades)

    // Demonstrate lazy initialization
    println("\nStudent status (lazy initialization):")
    println("${student1.name} is ${student1.status}")
    println("${student2.name} is ${student2.status}")

    // Demonstrate higher-order function
    println("\nProcessing grades with a function:")
    student1.processGrades { grade -> grade + 5 }
    println("Updated grades for ${student1.name}: ${student1.grades}")

    // Create a group
    val group = Group(arrayOf(student1, student2))
    println("\nGroup information:")
    println("Top student: ${group.getTopStudent()?.name}")

    // Demonstrate async/await
    println("\nFetching grades from server...")
    val deferredGrades = async { fetchGradesFromServer() }
    val newGrades = deferredGrades.await()
    student1.updateGrades(newGrades)
    println("Updated grades from server for ${student1.name}: ${student1.grades}")
}