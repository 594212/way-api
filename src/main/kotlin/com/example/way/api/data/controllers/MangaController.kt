package com.example.way.api.data.controllers

import com.example.way.api.components.MangaAssembler
import com.example.way.api.data.repositories.MangaRepository
import com.example.way.api.helpers.objects.MangaResponse
import exceptions.MangaNotFoundException
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors


@RestController
@RequestMapping("/manga")
class MangaController(
    val repository: MangaRepository,
    val assembler: MangaAssembler,
) {

    @GetMapping("/")
    fun getMangas(): CollectionModel<EntityModel<MangaResponse>> {

        val mangas = repository.findAll().map(assembler::toModel)
        return CollectionModel.of(mangas, linkTo(methodOn(MangaController::class.java).getMangas()).withSelfRel());
    }

    @GetMapping("/{manga_id}")
    fun getManga(@PathVariable("manga_id") mangaId: Long): EntityModel<MangaResponse> {
        val manga = repository.findById(mangaId)
            .orElseThrow() { MangaNotFoundException(mangaId) }

        return assembler.toModel(manga)

    }

    @GetMapping("/s")
    fun getMangasT(): List<MangaResponse>{

        val mangas = repository.findAll().map(assembler::toMangaResponse)
        return mangas
    }

}

