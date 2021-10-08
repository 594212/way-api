package com.example.way.api.data.controllers

import com.example.way.api.components.MangaAssembler
import com.example.way.api.data.models.Manga
import com.example.way.api.data.repositories.MangaRepository
import com.example.way.api.helpers.objects.ListMangaVO
import com.example.way.api.helpers.objects.MangaVO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/mangas")
class MangaController(val mangaRepository: MangaRepository,
                      val mangaAssembler: MangaAssembler) {

    @RequestMapping("/list")
    fun getMangas(httpServletRequest: HttpServletRequest): ResponseEntity<ListMangaVO> {
        return ResponseEntity.ok(mangaAssembler.toMangaListVO(mangaRepository.findAll() as List<Manga>))
    }


}