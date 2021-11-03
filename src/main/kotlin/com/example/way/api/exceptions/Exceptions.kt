package com.example.way.api.exceptions

import org.springframework.security.core.AuthenticationException

class JwtTokenMissingException(string: String): AuthenticationException(string)
