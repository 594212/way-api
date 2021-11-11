package com.example.way.api.helpers.objects

import javax.validation.constraints.*

data class MangaResponse(
        val id: Long,
        val name: String,
        val author: String,
        val slug: String,
        val chapter: Long,
        val updateAt: String,
)

data class MediaResponse(
        
        val id: Long,
        val name: String,
        val fileName: String,
        val mimeType: String,
        val size: Long,
        val createdAt :String,
        val updateAt: String
)

data class UserResponse(
        val id: Long,
        val name: String,
        val phone: String,
        val accountStatus: String
)

data class UserRequest(
        @NotBlank
        @NotEmpty
        val name: String,
        @Email
        val email: String,
        @Pattern(regexp = "^[+]?[7,8]?[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$")
        val phone: String,
        @Size(min = 5, max = 16)
        val password: String

)