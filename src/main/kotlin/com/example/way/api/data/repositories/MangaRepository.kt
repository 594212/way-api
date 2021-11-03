package com.example.way.api.data.repositories

import com.example.way.api.data.models.Manga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MangaRepository : JpaRepository<Manga,Long> {

}

