package com.example.way.api

import com.example.way.api.config.HttpSessionConfig
import com.example.way.api.data.controllers.MangaController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.AuthenticationFilter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.session.web.http.HeaderHttpSessionIdResolver
import org.springframework.session.web.http.SessionRepositoryFilter
import org.springframework.web.filter.CommonsRequestLoggingFilter

@SpringBootApplication
class WayApiApplication

fun main(args: Array<String>) {
    val applicationContext: ApplicationContext  = runApplication<WayApiApplication>(*args)
//    val sessionRepositoryFilter = applicationContext.getBean(SessionRepositoryFilter::class.java)
//    applicationContext.getBean(HttpSessionConfig::class.java)
//    applicationContext.getBean(HttpSecurity::class.java).addFilterBefore(sessionRepositoryFilter,
//        BasicAuthenticationFilter::class.java)


}

//@Configuration
//class RequestLoggingFilterConfig {
//    @Bean
//    fun logFilter(): CommonsRequestLoggingFilter {
//        val filter = CommonsRequestLoggingFilter()
//        filter.setIncludeQueryString(true)
//        filter.setIncludePayload(true)
//        filter.setMaxPayloadLength(10000)
//        filter.setIncludeHeaders(true)
////        filter.setAfterMessagePrefix("REQUEST DATA : ")
//        return filter
//    }
//
//}
