package com.example.way.api.helpers.objects

data class MangaVO(
        val id: Long,
        val name: String,
        val author: String,
        val pathImg: String,
        val chapter: Long?,
        val updateAt: String
)

data class ListMangaVO(
        val mangas: List<MangaVO>
)

data class MediaVO(
        val id: Long,
        val name: String?,
        val fileName: String?,
        val mimeType: String?,
        val size: Long?,
        val createdAt :String?,
        val updateAt: String?
)

data class ListMediaVO(
        val medias: List<MediaVO>
)