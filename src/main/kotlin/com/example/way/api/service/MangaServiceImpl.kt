//package com.example.way.api.service
//
//import com.example.way.api.data.models.Manga
//import com.example.way.api.data.repositories.MangaRepository
//import org.springframework.stereotype.Service
//import kotlin.jvm.Throws
//
//@Service
//class MangaServiceImpl(val mangaRepository: MangaRepository):MangaService {
//
//
//    override fun listManga(): List<Manga> {
//        return mangaRepository.findAll().mapTo(ArrayList()) { it }
//    }
//
//    @Throws(MangaInvalidException::class)
//    override fun retrieveThread(mangaId: Long): Manga {
//        val manga = mangaRepository.findById(mangaId)
//        if(!manga.isPresent) throw MangaInvalidException("Invalid manga id$mangaId'")
//        return manga.get()
//    }
//
//}