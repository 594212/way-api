package com.example.way.api.components

import com.example.way.api.data.controllers.MangaController
import com.example.way.api.data.models.Chapter
import com.example.way.api.data.models.Manga
import com.example.way.api.helpers.objects.MangaResponse
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Component

@Component
class MangaAssembler : RepresentationModelAssembler<Manga, EntityModel<MangaResponse>> {

    fun toMangaResponse(manga: Manga): MangaResponse {
//        val  lastChapter = lastChapter(manga.chapters)
//        val createAt: String = lastChapter?.createdAt.toString()
        return MangaResponse(
            id = manga.id,
            name = manga.name,
            chapter = 666 ?: 0,
            updateAt = manga.createdAt.toString(),
            author = manga.author ?: "Moderator",
            slug = manga.slug

        )
    }


    fun lastChapter(chapters: List<Chapter>?): Chapter? {
        if (chapters.isNullOrEmpty()) return null
        var maxElem = chapters.first()
        var maxVolume = maxElem.volume
        var maxChapter = maxElem.chapter

        chapters.forEach {
            val e = it
            val v = e.volume
            when {
                maxVolume < v -> {
                    maxElem = e
                    maxVolume = v
                    maxChapter = e.chapter
                }
                maxVolume == v -> {
                    val c = e.chapter
                    if (maxChapter < c) {
                        maxElem = e
                        maxChapter = c
                    }
                }
            }

        }

        return maxElem
    }

    override fun toModel(entity: Manga): EntityModel<MangaResponse> {
        return EntityModel.of(
            toMangaResponse(entity),
            linkTo(WebMvcLinkBuilder.methodOn(MangaController::class.java).getManga(mangaId = entity.id)).withSelfRel(),
            linkTo(WebMvcLinkBuilder.methodOn(MangaController::class.java).getMangas()).withRel("mangas")
        )
    }


}

