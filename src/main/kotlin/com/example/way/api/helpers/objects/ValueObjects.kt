package com.example.way.api.helpers.objects

data class MangaResponse(
        val id: Long,
        val name: String,
        val author: String,
        val slug: String,
        val chapter: Long,
        val updateAt: String
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
