package com.example.way.api

import com.example.way.api.data.controllers.MangaController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class WayApiApplication

fun main(args: Array<String>) {
    val applicationContext: ApplicationContext  = runApplication<WayApiApplication>(*args)
    applicationContext.getBean(MangaController::class.java)
}
