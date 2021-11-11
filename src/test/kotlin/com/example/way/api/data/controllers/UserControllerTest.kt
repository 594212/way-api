package com.example.way.api.data.controllers

import com.example.way.api.WayApiApplication
import com.example.way.api.components.UserAssembler
import com.example.way.api.config.HttpSessionConfig
import com.example.way.api.config.SecurityConfig
import com.example.way.api.data.repositories.UserRepository
import com.example.way.api.helpers.objects.UserRequest
import com.example.way.api.service.UserService
import com.example.way.api.service.UserServiceImpl
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(UserController::class)
//@SpringBootTest (classes = [HttpSessionConfig::class, SecurityConfig::class, WayApiApplication::class])
@AutoConfigureJson
@AutoConfigureJsonTesters
internal class UserControllerTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val json: JacksonTester<UserRequest>,
) {
    @MockBean
    lateinit var userAssembler: UserAssembler

//    @InjectMocks
//    lateinit var testInject: TestInject
    @MockBean
    lateinit var userService: UserService

//    @Mock lateinit var userRepository: UserRepository

    @Test
    fun getRegistration() {
        val userRequest: UserRequest = UserRequest(
            name = "adminNew",
            email = "webmaster@glavikrestyanam.site",
            phone = "+7(938)901-58-40",
            password = "lxgiwyl238"
        )
        val json = json.write(userRequest)
        print(json.json)
        assertThat(json).extractingJsonPathStringValue("$.name").isEqualTo(userRequest.name);
        assertThat(json).extractingJsonPathStringValue("$.email").isEqualTo(userRequest.email);
        assertThat(json).extractingJsonPathStringValue("$.phone").isEqualTo(userRequest.phone);
        assertThat(json).extractingJsonPathStringValue("$.password").isEqualTo(userRequest.password);


        val
                mockRequest = post("/registration").accept(MediaType.APPLICATION_JSON_VALUE)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(json.json)
        mockMvc.perform(mockRequest).andExpect(status().isCreated)

    }

    @Test
    fun load() {
    }
}

@ExtendWith(SpringExtension::class)
@WebMvcTest(EmptyController::class)
class HttpApiTests(
//    @Autowired val mockMvc: MockMvc,
//                   @MockBean val userRepository: UserRepository
//@MockBean val userRepository: UserRepository
) {

    @MockBean
    lateinit var userServiceImpl: UserServiceImpl

    //    @BeforeAll
    @Test
    fun foo() {
        userServiceImpl.getAll()
    }
}

@Controller
class EmptyController(val userServiceImpl: UserService) {

    fun hello(): String {
        print("hello")
        return "hello"
    }

}

class TestInject(val userRepository: UserRepository) {

}
