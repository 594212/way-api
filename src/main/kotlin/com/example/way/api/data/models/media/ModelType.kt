package com.example.way.api.data.models.media

import com.example.way.api.data.models.Chapter
import com.example.way.api.data.models.Manga
import javax.persistence.*

@Entity
class ModelType(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "chapter_id")
        val chapter: Chapter? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "manga_id")
        val manga: Manga? = null,
)
