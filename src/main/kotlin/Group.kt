package org.example

class Group(private val students: Array<Student>) {
    operator fun get(index: Int): Student {
        return students[index]
    }

    fun getTopStudent(): Student? {
        return students.maxByOrNull { it.getAverage() }
    }

    override fun toString(): String {
        return "Group(students=${students.contentToString()})"
    }
}