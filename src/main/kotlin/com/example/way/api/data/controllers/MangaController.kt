package com.example.way.api.data.controllers

import com.example.way.api.components.MangaAssembler
import com.example.way.api.components.MediaAssembler
import com.example.way.api.data.models.Manga
import com.example.way.api.data.models.Media
import com.example.way.api.data.repositories.MangaRepository
import com.example.way.api.helpers.objects.ListMangaVO
import com.example.way.api.helpers.objects.ListMediaVO
import com.example.way.api.helpers.objects.MangaVO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.servlet.http.HttpServletRequest
import kotlin.collections.ArrayList

@Controller
@RequestMapping("/mangas")
class MangaController(val mangaRepository: MangaRepository,
                      val mangaAssembler: MangaAssembler,
                        val mediaAssembler: MediaAssembler) {

    @GetMapping
    fun getMangas(httpServletRequest: HttpServletRequest): ResponseEntity<ListMangaVO> {
        val mangas: ArrayList<Manga> = ArrayList()
        mangas.addAll(mangaRepository.findAll())
        return ResponseEntity.ok(mangaAssembler.toMangaListVO(mangas))

    }

    @GetMapping("/{manga_id}")
    fun getImageManga(@PathVariable("manga_id") mangaId: Long,
                      request: HttpServletRequest): ResponseEntity<ListMediaVO> {
        val media = mutableListOf<Media>()

            mangaRepository.findById(mangaId).map {
            media.addAll(it.media)
        }
        mangaRepository.findById(mangaId).map {
            media.addAll(it.chapters.flatMap { it.media })
        }
        return ResponseEntity.ok( mediaAssembler.toMediaListVO(media))
    }

}

