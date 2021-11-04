package com.example.way.api

import com.example.way.api.config.HttpSessionConfig
import com.example.way.api.config.SecurityConfig
import org.hamcrest.core.IsNull.notNullValue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import org.springframework.security.web.FilterChainProxy
import org.springframework.session.Session
import org.springframework.session.web.http.SessionRepositoryFilter
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.MockMvcConfigurer
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import java.util.*


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [HttpSessionConfig::class, SecurityConfig::class,WayApiApplication::class])
@WebAppConfiguration
class WayApiApplicationTests(
    @Autowired
    private var context: WebApplicationContext,
) {
    private val sessionRepositoryFilter = context.getBean(SessionRepositoryFilter::class.java)

    private val mockMvc: MockMvc = MockMvcBuilders.webAppContextSetup(context)
        .addFilters<DefaultMockMvcBuilder>(sessionRepositoryFilter).apply<
                DefaultMockMvcBuilder>(springSecurity()).build()

    private val request: MockHttpServletRequestBuilder = get("/")
        .header(
            "Authorization", "Basic " +
                    Base64.getEncoder().encodeToString("Admin:lxgiwyl238".toByteArray())
        )


    @Test
    fun load(){
    }

    @Throws(Exception::class)
    @Test
    fun getSessionToken() {
        mockMvc.perform(request)
            .andExpect(status().is2xxSuccessful)
            .andExpect(header().string("X-Auth-Token", notNullValue()))

    }

    @Throws(Exception::class)
    @Test
    fun getJSessionId() {
        mockMvc.perform(request)
            .andExpect(status().is2xxSuccessful)
            .andExpect(cookie().doesNotExist("JSESSIONID"))
    }


}
