package com.example.way.api.data.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@DiscriminatorValue("App\\Models\\Chapter")
@Table(name = "chapters")
data class Chapter(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        override val id: Long = 0,

        @Column(columnDefinition = "boolean default 1")
        val volume: Int = -1,

        @get: NotBlank
        val chapter: Long = -1,
        @Column(columnDefinition = "boolean default false")
        val type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "manga_id")
        val manga: Manga = Manga(),

        ) : HasMedia() {
    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, targetEntity = Media::class)
    val media: Collection<Media> = mutableListOf()

}


