package day_2_collections_sql.collections

import java.util.ArrayList
import java.util.LinkedList
import kotlin.system.measureTimeMillis


fun main() {
    hashMapPractice()
}

fun listPractice() {
    val num1 = 1000000
    val arrayNumber = ArrayList<Int>(num1)
    val linkedNumber = LinkedList<Int>()

    for (i in 0 until num1) {
        arrayNumber.add(i)
        linkedNumber.add(i)
    }

    val calculateArrayMs = measureTimeMillis {
        repeat(10000) {
            val randomArray = arrayNumber.random()
            // here the array list is O(1).
            // That means that to access a specific number, it just jumps up to that index
            // It doesn't check all the numbers, directly to that specific index
            // And it takes less time to search that number compared to Linked Lists.
            // Directly catching an index without looking for other number is basically O(1)
        }
    }

    val calculateLinkedMs = measureTimeMillis {
        repeat(10000) {
            val randomLinked = linkedNumber.random()
            // here Linked list uses O(n)
            // that Linked list accesses by nodes
            // to find a specific number, unlike array list,
            // it doesn't jump directly to the specific index
            // rather it access one by one each element
            // then if it finds it, it stops. It takes more time to access.
            // That is basically O(n), accessing each element and taking more time
        }
    }

    println("It took $calculateArrayMs ms to find that random number for the array list")
    println("It took $calculateLinkedMs ms to find that random number for the linked list")


    // contains() performs a linear search for both ArrayList and LinkedList (O(n))
    // we'll see it below
    val arrayValueSearchingTime = measureTimeMillis {
        val searchArray = arrayNumber.contains(999999)
    }

    val linkedValueSearchingTime = measureTimeMillis {
        val searchLinked = linkedNumber.contains(999999)
    }

    println("For searching value, the time the array list took $arrayValueSearchingTime ms")
    println("For searching value, the time the linked list took $linkedValueSearchingTime ms")
}




fun setsPractice() {
    // Let's create a list first
    val fruits = listOf<String>("apple", "banana", "blackberries", "mango", "blackberries")
    println(fruits)

    // now let's convert this list to 'set'
    val setOfFruits = fruits.toSet()
    println(setOfFruits)

    // If we run this set of fruits, we'll notice that it deleted 1 blackberries
    // There were 2 blackberries in the list but when it became set
    // There's only 1. So what's going on actually in the set?
    // Well, basically set deletes duplicate elements and keeps the rest.
    // But the question is how does set know that there's a duplicate element?
    // It's because of hashCode() and equals() method. hashCode() is the scanner. Let's understand it.
    // Inside collections types like list or set, set generates a number for every object via hashCode()
    // that number is basically called hashcode. hashCode() checks if there's duplicate elements
    // If there is, then hash uses equals() method to match the duplicate names, if it finds duplicate
    // It rejects the duplicate and deletes the copy. That's how basically hashCode() works
}



fun hashMapPractice() {
    val students = HashMap<Int, String>()

    students[0] = "Alice"
    students[1] = "Bob"
    students[2] = "Mariya"
    students[3] = "Charlie"

    println("The student with ID number 2 is ${students[2]}")


    // Question: What is the time complexity of finding a value in a HashMap by its key?
    // Answer: The time complexity of finding a value in a Hashmap by its key is O(1) on average
    // There can be some exceptions where HashMap collisions, and it could go slower like 0(n)
    // Because The key is already specified as an object. So it doesn't go
    // like a list scanning one by one. Rather it directly jumps to the key where it's stored inside the map, just like the behaviour of O(1)
    // In summary, HashMap uses the key's hashCode() to directly access that element.
}