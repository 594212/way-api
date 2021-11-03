package com.example.way.api.service

import com.example.way.api.data.models.User
import com.example.way.api.data.repositories.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.Throws


@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun getAll(): List<User> {
        return userRepository.findAll()
    }

    @Throws(UsernameNotFoundException::class)
    override fun getByName(login: String): User {
        return userRepository.findByUsername(login)
            ?: throw UsernameNotFoundException("A user with the username $login not exist")
    }
}