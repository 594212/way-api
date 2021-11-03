package com.example.way.api.config

import com.example.way.api.service.AppUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.savedrequest.NullRequestCache


@EnableWebSecurity
class SecurityConfig(val userDetails: AppUserDetails) : WebSecurityConfigurerAdapter() {
    // @formatter:off
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests { authorize ->
                authorize
                    .anyRequest().authenticated()
            }
            .requestCache { requestCache ->
                requestCache
                    .requestCache(NullRequestCache())
            }
            .httpBasic(Customizer.withDefaults())
//            .userDetailsService(userDetails)
    }

    // @formatter:on
    @Autowired
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetails).passwordEncoder(BCryptPasswordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}

