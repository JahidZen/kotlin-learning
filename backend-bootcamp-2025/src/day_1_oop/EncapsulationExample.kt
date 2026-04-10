package day_1_oop

class Ac(private var mode: String, private var temperature: Int) {
    fun getMode(): String {
        return mode
    }

    fun getTemperature(): Int {
        return temperature
    }

    fun setTemperature(newTemp: Int) {
        when(newTemp) {
            in 23..32 -> {
                temperature = newTemp
                mode = "Hot"
                println("It's $mode mode and Temperature is set to $newTemp Celsius")
            }
            in 16..22 -> {
                temperature = newTemp
                mode = "Cool"
                println("It's $mode mode and Temperature is set to $newTemp Celsius")
            }
            else -> println("$newTemp is invalid temperature !")
        }
    }
}


fun main() {
    val acSettings = Ac("Hot", 28)

    acSettings.setTemperature(99)
    acSettings.setTemperature(22)
    acSettings.setTemperature(23)


    println("Final mode: ${acSettings.getMode()}")
    println("Final temperature: ${acSettings.getTemperature()}")
}