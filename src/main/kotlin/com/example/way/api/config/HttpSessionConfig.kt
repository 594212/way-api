package com.example.way.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.MapSessionRepository
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession
import org.springframework.session.web.http.HeaderHttpSessionIdResolver
import org.springframework.session.web.http.HttpSessionIdResolver
import java.util.concurrent.ConcurrentHashMap

@EnableSpringHttpSession
@Configuration
class HttpSessionConfig {
    @Bean
    fun httpSessionIdResolver(): HttpSessionIdResolver = HeaderHttpSessionIdResolver.xAuthToken()
    @Bean
    fun sessionRepository(): MapSessionRepository = MapSessionRepository(ConcurrentHashMap())
}