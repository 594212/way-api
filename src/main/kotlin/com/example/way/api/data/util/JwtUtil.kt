//package com.example.way.api.data.util
//
//import com.example.way.api.data.models.User
//import io.jsonwebtoken.JwtException
//import io.jsonwebtoken.Jwts
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.security.core.Authentication
//import kotlin.jvm.Throws
//
//class JwtUtil(
//    @Value("\${jwt.secret}")
//    private val SECRET: String,
//    @Value("\${jwt.lifetime")
//    private val TOKEN_EXPIRY:Long
//)
//
//    private val AUTH_HEADER_KEY: String = "Authorization"
//    private val TOKEN_PREFIX: String = "Bearer"
//{
//    @Throws(JwtException::class)
//    fun parseToken(token: String): Authentication {
//            val body = Jwts
//                .parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .body ?: throw JwtException(null)
//
//
//    }
//
//    fun generateToken( user: User): String {
//        val claims = Jwts.claims().setSubject(user).put("")
//    }
//
//}