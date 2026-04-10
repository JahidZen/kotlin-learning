package day_1_oop

open class Car(val brand: String, val speed: Double) {
    fun normalCar() {
        println("$brand has a top speed of $speed km/h")
    }
}

class SedanCar(brand: String, speed: Double, val doorCount: Int): Car(brand, speed) {
    fun carFeature() {
        println("$brand has a top speed of $speed km/h and it has $doorCount doors.")
    }
}

class SuvCar(brand: String, speed: Double, val engine: String): Car(brand, speed) {
    fun suvFeature() {
        println("$brand has a top speed of $speed km/h and the engine type is $engine")
    }
}


fun main() {
    val basicCar = Car("Toyota", 180.00)
    val specialCar = SedanCar("Lamborghini", 300.00, 2)
    val specialCar1 = SuvCar("Range rover", 250.00, "Petrol")

    basicCar.normalCar()
    specialCar.carFeature()
    specialCar1.suvFeature()
}