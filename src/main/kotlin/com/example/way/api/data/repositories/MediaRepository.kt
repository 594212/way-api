package com.example.way.api.data.repositories

import com.example.way.api.data.models.Post
import org.springframework.data.jpa.repository.JpaRepository

interface MediaRepository: JpaRepository<Post,Long> {
}