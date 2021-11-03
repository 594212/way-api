package com.example.way.api

import com.example.way.api.data.controllers.MangaController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@SpringBootApplication
class WayApiApplication

fun main(args: Array<String>) {
    val applicationContext: ApplicationContext  = runApplication<WayApiApplication>(*args)
    applicationContext.getBean(MangaController::class.java)
}

@Configuration
class RequestLoggingFilterConfig {
    @Bean
    fun logFilter(): CommonsRequestLoggingFilter {
        val filter = CommonsRequestLoggingFilter()
        filter.setIncludeQueryString(true)
        filter.setIncludePayload(true)
        filter.setMaxPayloadLength(10000)
        filter.setIncludeHeaders(true)
//        filter.setAfterMessagePrefix("REQUEST DATA : ")
        return filter
    }

}
