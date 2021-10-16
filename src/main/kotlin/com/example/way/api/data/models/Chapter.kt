package com.example.way.api.data.models

import com.example.way.api.data.models.media.HasMedia
import com.example.way.api.data.models.media.ModelType
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "chapters")
class Chapter(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id :Long = 0,

        @Column(columnDefinition = "boolean default 1")
        var volume: Int = -1,

        @get: NotBlank
        var chapter: Long = -1,
        @Column(columnDefinition = "boolean default false")
        var type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "manga_id")
        var manga: Manga? = null,

): HasMedia  {
        @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, targetEntity = ModelType::class)
        val media: List<ModelType> = mutableListOf()
}