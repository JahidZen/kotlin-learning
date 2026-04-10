class Phone(val brand: String, val model: String, val price: Double) {
    fun call() {
        println("The phone's specifications: BRAND: $brand, MODEL: $model, PRICE: $price$")

    }
}

fun main() {
    val phone1 = Phone("Samsung", "Galaxy S25 Ultra", 1000.00)
    val phone2 = Phone("Iphone", "17 Pro Max", 1200.00)

    phone1.call()
    phone2.call()

    // calling the other function inside it
    executingFunction()
    random()
    objectsOfCars()
    bankAccount()
    handlingTemperature()
    studentObjects()
}


class Student(val name: String, val age: Int, val grade: Char) {
    fun introduce() {
        println("Hi, I'm $name, I'm $age years old, my grade is $grade")
    }
}

fun executingFunction() {
    val student1 = Student("Jahid Khan", 19, 'B')
    val student2 = Student("Mariya Khan", 21, 'A')

    // printing the values
    student1.introduce()
    student2.introduce()
}


fun random() {
    val unicodeValue = 'z'.code
    println(unicodeValue) // Output: 65
}

// Let's create a blueprint for a car
class Car(val brand: String, val model: String, val year: Int) {
    fun displayInfo() {
        println("The brand of the car is $brand, the model is $model and the year of the car is $year")
    }
}

fun objectsOfCars() {
    val car1 = Car("Toyota", "Corolla", 2023)
    val car2 = Car("Ford", "Mustang GT", 2025)


    // calling the cars to be printed according to the blueprint in the class
    car1.displayInfo()
    car2.displayInfo()
}



// Creating 2 bank account with some deposit and withdrawal functions, also handling errors and validating user inputs. Starting by the blueprint about how the accounts should behave.
class BankAccount(val accountHolder: String, var balance: Double) {
    fun deposit() {
        do {
            println("Add amount into your account:")
            val addAmount = readLine()?.toIntOrNull()
            if (addAmount == null || addAmount <= 0) { // If null and negative numbers given by user, it'll ask for adding amount again.
                println("Minimum 1 Euro amount required.")
            }
            else {
                balance += addAmount // updating balance
                println("€$addAmount added successfully! $accountHolder's bank account has been created! Current balance: $balance")
            }
        } while (addAmount == null || addAmount <= 0)
    }


    fun withdraw() {
        do {
            println("Withdrawal amount:")
            val withdrawal = readLine()?.toDoubleOrNull()
            if (withdrawal == null || withdrawal <= 0) { // If null and negative numbers given by user, it'll ask for the withdrawal amount again.
                println("Invalid withdrawal amount!")
            }
            else if (withdrawal > balance) {
                println("Insufficient balance! Current balance: €$balance")
            }

            else {
                balance -= withdrawal // updating balance after withdrawal
                println("€$withdrawal withdrawn successfully✔️ Current balance: €$balance")
                break // exiting loop after withdrawing successfully
            }

        } while (true)
    }



    fun displayBalance() {
        println("Current balance is $balance")
    }
}

fun bankAccount() {
    val bankAccount1 = BankAccount("Jahid Khan", 0.0)
    val bankAccount2 = BankAccount("Mariya Khan", 0.0)

    // printing the accounts
    bankAccount1.deposit()
    bankAccount1.withdraw()
    bankAccount1.displayBalance()
    bankAccount2.deposit()
    bankAccount2.withdraw()
    bankAccount2.displayBalance()

}


class Product(val price: Double) {
    
}


class Temperature(val celcius: Double) {
    fun toFahrenheit() {
        val convertFahrenheit = (celcius * 1.8) + 32 // Multiply the °C temperature by 1.8. Add 32 to this number.
        println("The temperature in Fahrenheit= %.2f".format(convertFahrenheit))
    }

    fun toKelvin(){
        val convertKelvin = celcius + 273.15 //  Kelvin = Celsius + 273.15
        println("The temperature in Kelvin= %.2f".format(convertKelvin))
    }
}

fun handlingTemperature() {
    var userTemperature: Double? = null

    while (userTemperature == null) {
        println("Please enter the temperature:")
        userTemperature = readlnOrNull()?.toDoubleOrNull()

        if (userTemperature == null) {
            println("Please enter a valid temperature number.")
        }
    }

    val temperature = Temperature(userTemperature) // Now it's safe

    temperature.toFahrenheit()
    temperature.toKelvin()
}






// creating a class for student registration
class StudentInfo (val name: String, val gender: String, val age: Int, val email: String, val courseName: String) {
    fun registration() {
        println("Student's name is $name. $gender's $age years old. The email address of the student is $email. And the course he's enrolled is $courseName.")
    }
}

fun studentObjects() {
    // calling the regex patterns here to verify name, email and gender
    val nameRegex = "^[a-zA-Z ]+$".toRegex() //
    val regexEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$".toRegex()
    val regexGender = "^(M|F|O)$".toRegex()



    // calling variables outside the loop to access them later
    var name: String?
    var age: Int?
    var email: String?
    var courseName: String?
    var gender: String?


    while (true) {
        // taking name from student
        println("Dear student, please enter your name:")
        name = readlnOrNull() // input can be null too
        if (name.isNullOrEmpty() || !name.matches(nameRegex))
            println("Please enter a valid name!")
        else {
            println("Your name is $name ✔️")
            break
        }

    }



    while (true) {
        // taking age from student
        println("Please enter your age:")
        age = readlnOrNull()?.toIntOrNull()
        if (age == null) {
            println("Please enter a valid age")
        } else if (age < 10 || age > 100) {
            println("Age requirement doesn't match!")
        } else {
            println("Your age is $age✔️")
            break
        }
    }


    while (true) {
        // taking email from student
        println("Please enter your email address:")
        email = readlnOrNull()
        if (email.isNullOrEmpty() || !email.matches(regexEmail)) {
            println("Please enter a valid email address")
        }
        else {
            println("$email registered✔️")
            break
        }

    }


    while (true) {
        // taking course name
        println("Please enter your course name:")
        courseName = readlnOrNull()
        if (courseName.isNullOrEmpty()) {
            println("Course name required!")
        }
        else {
            println("Your course is $courseName✔️")
            break
        }
    }



    while (true) {
        // asking the user for their gender
        println("What's your gender? Write 'M' if you're male and 'F' if you're female and 'O' if it's others.")
        gender = readlnOrNull()
        if (gender.isNullOrEmpty() || !gender.matches(regexGender)) {
            println("Only inputs of 'M' 'F' 'O' allowed.")
        }
        else {
            println("Your gender is $gender")
            break
        }
    }


    val student = StudentInfo(name!!, gender!!, age!!, email!!, courseName!!)
    student.registration()
}

