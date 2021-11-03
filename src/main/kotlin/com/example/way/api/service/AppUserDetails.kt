package com.example.way.api.service

import com.example.way.api.data.repositories.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class AppUserDetails(val repository: UserRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByUsername(username)
            ?: throw UsernameNotFoundException("A user with the username $username not exist")
        return User(
            user.username,
            user.password,
            ArrayList<GrantedAuthority>()
        )
    }
}