fun main() {
// calling the functions to execute
    registerUser()
    calculateDiscount()
}

fun registerUser() {

    do {
        val namePattern = "^[A-Za-z\\s]+$".toRegex()
        println("Please enter your name:") // the name must be written with letters and spaces
        val name = readln() // safely asking for user input
        // handling null issue safely
        if (!name.matches(namePattern) || name.isNullOrEmpty()) {
            println("Please enter a valid name (It cannot be empty and cannot contain numbers)")
        }
        else {
            println("Your name $name registered successfully")
        }


        println("Please enter your age:")
        val age = readLine()?.toIntOrNull() // asking for user input
        if (age == null) {
            println("Age can only contain whole numbers. Please enter a valid age")
        }

        else {
            println("Your are $age years old ✔️")
        }
    }
        while (name.matches(namePattern) && !name.isNullOrEmpty() && age != null)
}


fun calculateDiscount() {
    do {
        println("Tell your age again to calculate discount:")
        val age = readLine()?.toIntOrNull()
        if (age == null) {
            println("Invalid age provided")
        }
        else if (age < 18) {
            println("You get a 20% discount!")
        }
        else {
            println("No discount available.")
        }

    }
        while (age != null)


}