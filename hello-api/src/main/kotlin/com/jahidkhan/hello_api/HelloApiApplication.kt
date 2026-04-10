package com.jahidkhan.hello_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloApiApplication

fun main(args: Array<String>) {
	runApplication<HelloApiApplication>(*args)
}
