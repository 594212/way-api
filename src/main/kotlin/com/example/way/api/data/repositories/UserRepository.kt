package com.example.way.api.data.repositories

import com.example.way.api.data.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long> {
    fun findByUsername(username: String): User?

}