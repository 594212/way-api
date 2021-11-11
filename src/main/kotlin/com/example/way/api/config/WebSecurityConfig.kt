package com.example.way.api.config

import com.example.way.api.WayApiApplication
import com.example.way.api.service.AppUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.savedrequest.NullRequestCache
import org.springframework.session.web.http.SessionRepositoryFilter


@EnableWebSecurity
class SecurityConfig(
    val userDetails: UserDetailsService
) : WebSecurityConfigurerAdapter() {
    // @formatter:off

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.csrf().disable()
            .authorizeRequests()
        { authorize ->
            authorize
                .antMatchers(HttpMethod.GET,"/manga/s").permitAll()
                .antMatchers(HttpMethod.POST,"/registration").permitAll()
                .anyRequest().authenticated()
        }.requestCache { requestCache ->
                requestCache
                    .requestCache(NullRequestCache())
            }.httpBasic(Customizer.withDefaults())




    }

//    @Autowired
//    @Throws(Exception::class)
//    fun configureGlobal(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//            .withUser(User.withUsername("Sul").password("{noop}password").roles("USER").build())
//    }


    @Autowired
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetails).passwordEncoder(BCryptPasswordEncoder())
    }

}



