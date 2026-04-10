fun main() {
    // calling the functions to execute here
    registerNameAndAge()
    userEmail()
    deposit()

}

fun registerNameAndAge() {
    // Creating a bank system where user creates an account by their providing name, age

    do {
        val namePattern = "^[A-Za-z\\s]+$".toRegex() // the name must be written with upper and lower case letters and spaces

        println("Please enter your name:")

        val name = readln() // asking user to input their name

        // checking if the name matches the regex format where the user can only input letters and spaces. Nothing else.
        // also handling null or invalid issues safely and without crashing
        if (!name.matches(namePattern) || name.isEmpty()) {
            println("Please enter a valid name (It cannot be empty and cannot contain numbers)")
        } else {
            println("Your name $name registered successfully")
        }
    } while (!name.matches(namePattern) || name.isEmpty())


    do {
        println("Please enter your age:")
        val age = readlnOrNull()?.toIntOrNull() // asking user to input their age
        // handling null issue without crashing
        if (age == null) {
            println("Age can only contain whole numbers. Please enter a valid age")
        }

        else {
            println("Your are $age years old ✔️")
        }
    } while (age == null)
}








fun userEmail() {
    // asking user to give valid email address for the bank account
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex() // regex pattern for email validation

    do {
        println("Please enter your valid email:")

        val userInput = readln() // asking to input user's email address


        // handling invalid issues by checking if the user's input is empty or if their input doesn't match a valid email format which is patterned in *regexEmail
        if (userInput.isEmpty() || !userInput.matches(emailRegex)) {
            println("The provided email is not valid! Please provide a valid email address")
        }
        else {
            println("Your email registered successfully✔️")
        }
    }
    while (userInput.isEmpty() || !userInput.matches(emailRegex))

}


fun deposit() {
    // To create the bank account of the user, we got their name, age, email address. Now it's time for their initial payment to open the bank account successfully.
    println("You have to deposit an initial amount of money to open the bank account successfully.")

    var deposit: Int?

    do {
        // need an initial deposit to create the bank account
        println("Amount you want to deposit (In EURO):")
        deposit = readlnOrNull()?.toIntOrNull() // asking the user to input deposit a minimum amount and handling null issue by allowing null input
        if (deposit == null || deposit <= 0 || deposit < 5) {
            println("Minimum 5 Euro or equivalent amount required!")
        }
        else {
            println("Bank account created successfully✔️")
        }
    } while (deposit == null || deposit <= 0 || deposit < 5)
    println("Current balance: $deposit")



    // now it's time to include the withdrawal feature for the users.
    do {
        println("Money withdrawal:")

        val withdraw = readlnOrNull()?.toIntOrNull() //asking how much the user wants to withdraw and handling null issue by allowing null

        if (withdraw == null || withdraw <= 0) {
            println("Invalid input! Please input a valid number of amount to withdraw!")
        }
        else if (withdraw > deposit) {
            println("Insufficient balance to withdraw! Please make sure that you have enough balance.")
        }
        else {
            deposit -= withdraw // equivalent of deposit: val deposit = deposit - withdraw
            println("Withdraw is successful! ✔️")
            println("New current balance: $deposit")
        }

    } while (withdraw == null || withdraw <= 0 || withdraw > deposit)

}