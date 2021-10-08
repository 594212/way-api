package com.example.way.api.helpers.objects

data class MangaVO(
        val id: Long,
        val name: String,
        val author: String,
        val pathImg: String,
        val updateAt: String
)

data class ListMangaVO(
        val mangas: List<MangaVO>
)