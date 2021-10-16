package com.example.way.api.components

import com.example.way.api.data.models.Chapter
import com.example.way.api.data.models.Manga
import com.example.way.api.helpers.objects.ListMangaVO
import com.example.way.api.helpers.objects.MangaVO
import org.springframework.stereotype.Component

@Component
class MangaAssembler {

    fun toMangaVO(manga: Manga): MangaVO {
        val  lastChapter = lastChapter(manga.chapters)
        val createAt: String = lastChapter?.createdAt.toString()
        return MangaVO(
                id = manga.id,
                name = manga.name,
                author = manga.author,
                pathImg = manga.slug,
                chapter = lastChapter?.chapter,
                updateAt = createAt
        )
    }


    fun toMangaListVO(mangas: List<Manga>): ListMangaVO {
        val mangaListVO = mangas.map { toMangaVO(it) }
        return ListMangaVO(mangaListVO)
    }

    fun lastChapter(chapters: List<Chapter>?): Chapter? {
        if(chapters.isNullOrEmpty()) return null
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


}

