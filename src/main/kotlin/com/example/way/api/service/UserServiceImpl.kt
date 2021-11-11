package com.example.way.api.service

import com.example.way.api.data.models.User
import com.example.way.api.data.repositories.UserRepository
import com.example.way.api.helpers.objects.UserRequest
import exceptions.UsernameUnavailableException
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.Throws


@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun getAll(): List<User> {
        return userRepository.findAll()
    }

    @Throws(UsernameUnavailableException::class)
    override fun createUser(userRequest: UserRequest): User {

        val user = User(
            username = userRequest.name,
            email = userRequest.email,
            password = userRequest.password,
            phoneNumber = userRequest.phone
        )
        if (userExist(user)) throw UsernameUnavailableException("The username ${userRequest.name} is unavailable")

        userRepository.save(user)
        obscurePassword(user)

        return user
    }

    override fun userExist(user: User): Boolean = userRepository.findByUsername(username = user.username) != null

    @Throws(UsernameNotFoundException::class)
    override fun getByName(login: String): User {
        return userRepository.findByUsername(login)
            ?: throw UsernameNotFoundException("A user with the username $login not exist")
    }


    private fun obscurePassword(user: User?) {
        user?.password = "XXX XXXX XXX"
    }
}