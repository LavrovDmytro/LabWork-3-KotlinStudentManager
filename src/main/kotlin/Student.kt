package org.example

class Student(
    private var _name: String,
    private var _age: Int,
    private var _grades: List<Int>
) {
    // Secondary constructor
    constructor(name: String) : this(name, 0, emptyList())

    // Init block
    init {
        println("Student object created: $name")
    }

    // Properties with getters and setters
    var name: String
        get() = _name
        set(value) {
            _name = value.trim().replaceFirstChar { it.uppercase() }
        }

    var age: Int
        get() = _age
        set(value) {
            if (value >= 0) {
                _age = value
            }
        }

    var grades: List<Int>
        get() = _grades
        private set(value) {
            _grades = value
        }

    val isAdult: Boolean
        get() = age >= 18

    val status: String by lazy {
        if (isAdult) "Adult" else "Minor"
    }

    // Methods
    fun getAverage(): Double {
        return if (grades.isEmpty()) 0.0 else grades.average()
    }

    fun processGrades(operation: (Int) -> Int) {
        _grades = grades.map(operation)
    }

    fun updateGrades(newGrades: List<Int>) {
        _grades = newGrades
    }

    // Operator overloading
    operator fun plus(other: Student): List<Int> {
        return this.grades + other.grades
    }

    operator fun times(multiplier: Int): List<Int> {
        return grades.map { it * multiplier }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Student) return false
        return name == other.name && getAverage() == other.getAverage()
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + getAverage().hashCode()
        return result
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, grades=$grades, status=$status, average=${getAverage()})"
    }
} 