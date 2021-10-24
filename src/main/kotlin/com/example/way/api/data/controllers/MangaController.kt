package com.example.way.api.data.controllers

import com.example.way.api.components.MangaAssembler
import com.example.way.api.components.MediaAssembler
import com.example.way.api.data.models.Manga
import com.example.way.api.data.repositories.MangaRepository
import com.example.way.api.helpers.objects.ListMangaVO
import com.example.way.api.helpers.objects.ListMediaVO
import com.example.way.api.helpers.objects.MangaVO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

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
        val manga: Manga = mangaRepository.findById(mangaId).get()
        return ResponseEntity.ok( mediaAssembler.toMediaListVO(manga.media))
    }

}