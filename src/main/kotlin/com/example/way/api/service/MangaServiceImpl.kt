package com.example.way.api.service

import com.example.way.api.data.models.Manga
import com.example.way.api.data.repositories.MangaRepository
import kotlin.jvm.Throws

class MangaServiceImpl(val mangaRepository: MangaRepository):MangaService {

    override fun listManga(): List<Manga> {
        val
    }

    @Throws(MangaInvalidException::class)
    override fun retrieveThread(mangaId: Long): Manga {
        val manga = mangaRepository.findById(mangaId)
        if(!manga.isPresent) throw MangaInvalidException("Invalid manga id$mangaId'")
        return manga.get()
    }
}