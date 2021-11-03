package com.example.way.api.service

import com.example.way.api.data.models.User
import org.springframework.stereotype.Service

interface UserService {
    fun getByName(login : String): User
    fun getAll(): List<User>

}