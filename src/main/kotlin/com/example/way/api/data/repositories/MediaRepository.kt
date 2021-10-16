package com.example.way.api.data.repositories

import com.example.way.api.data.models.MediaGhost
import org.springframework.data.jpa.repository.JpaRepository

interface MediaRepository: JpaRepository<MediaGhost,Long> {
}