package com.example.way.api.data.repositories

import com.example.way.api.data.models.Media
import org.springframework.data.jpa.repository.JpaRepository

interface MediaRepository: JpaRepository<Media,Long> {
}