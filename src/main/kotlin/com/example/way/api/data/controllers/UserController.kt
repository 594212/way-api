package com.example.way.api.data.controllers

import com.example.way.api.components.UserAssembler
import com.example.way.api.helpers.objects.UserResponse
import com.example.way.api.service.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController(
    val userService: UserService,
    val userAssembler: UserAssembler
) {
    @GetMapping(path = ["/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getAll(): List<UserResponse> {
        return userService.getAll().map(userAssembler::toUserResponse)

    }

    @RequestMapping(value = ["/"], produces = ["application/json"])
    fun helloUser(principal: Principal): Map<String, String> {
        val result = HashMap<String, String>()
        result["Hello username"] = principal.name

        return result
    }
}
