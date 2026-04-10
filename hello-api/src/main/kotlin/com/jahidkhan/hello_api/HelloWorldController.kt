package com.jahidkhan.hello_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random // importing the random number machine from kotlin library

// @RestController tells Spring that this class will handle web requests.
@RestController
class HelloWorldController {

    // @GetMapping("/hello") tells Spring to run this function
    // when someone accesses the "/hello" URL.
    @GetMapping("/number")
    fun sayHello(): String {
        val randomNum = Random.nextInt(1, 100) // takes a random number between 1 and 100
        val message = if (randomNum % 2 == 0) { // using if-else as expressions
            "This an even number: $randomNum"  // and checking if the random number is divisible by 2 or not
        }
        else {
            "This is an odd number: $randomNum"
        }
        return message
    }
}