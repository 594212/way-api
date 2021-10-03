package com.example.way.api.service

import com.example.way.api.data.models.Manga

interface MangaService {
    fun listManga(): List<Manga>
    fun retrieveThread(mangaId: Long): Manga
}