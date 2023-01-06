package com.example.consome_apis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ConsomeApisApplication

fun main(args: Array<String>) {
    runApplication<ConsomeApisApplication>(*args)
}
