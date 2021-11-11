package com.example.way.api.service

import com.example.way.api.data.models.User
import com.example.way.api.helpers.objects.UserRequest
import org.springframework.stereotype.Service

interface UserService {
    fun getByName(login : String): User
    fun getAll(): List<User>
    fun createUser(user: UserRequest): User
    fun userExist(user: User):Boolean
}