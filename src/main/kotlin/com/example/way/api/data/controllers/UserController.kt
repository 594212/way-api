package com.example.way.api.data.controllers

import com.example.way.api.components.UserAssembler
import com.example.way.api.data.models.User
import com.example.way.api.helpers.objects.UserRequest
import com.example.way.api.helpers.objects.UserResponse
import com.example.way.api.service.UserService
import com.example.way.api.service.UserServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
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

    fun helloUser(auth: Authentication): Map<String, String> {
        val result = HashMap<String, String>()
        result["auth.name"] = auth.name
        result["auth.principal"] = auth.authorities.toString()
        return result
    }

    @PostMapping(value = ["/registration"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getRegistration(@Validated @RequestBody userDetails: UserRequest): ResponseEntity<UserResponse> {
        val user = userService.createUser(userDetails)
        return ResponseEntity(userAssembler.toUserResponse(user),HttpStatus.CREATED)
    }


    @PostMapping(value = ["/post"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPost(
        @Validated
        @RequestBody userDetails: UserRequest
    ): ResponseEntity<String>{
        val result = HashMap<String, String>()
        result["registration"] = "success"
        return ResponseEntity.ok("success")
    }


}

