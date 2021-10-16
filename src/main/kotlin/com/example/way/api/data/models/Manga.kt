package com.example.way.api.data.models

import com.example.way.api.data.models.media.HasMedia
import com.example.way.api.data.models.media.ModelType
import com.example.way.api.extention.cyr2lat
import com.example.way.api.extention.toSlug
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table(name = "mangas")
data class Manga(
        @Column(columnDefinition = "varchar(255) default 'empty-name'")
        var en_name: String = "",
        @Column(columnDefinition = "varchar(255) default ' '")
        var description: String = "",
        @Column(columnDefinition = "varchar(255) default 'В процессе'")
        var status: String = "",
        @Column(columnDefinition = "integer default 9999")
        var year: Int = 0,
        @Column(columnDefinition = "varchar(255) default 'неизвестно'")
        var language: String = "",
        @Column(columnDefinition = "varchar(255) default 'неизвестно'")
        var author: String = "",

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @get: NotBlank
        var name: String = "",
        @Column(columnDefinition = "boolean default false")
        var type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),
): HasMedia {
    val slug: String =  "${name.cyr2lat().toSlug()}$id"

    @OneToMany(mappedBy = "manga", targetEntity = Chapter::class,
            cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    var chapters: List<Chapter>? = mutableListOf()

    @OneToOne(targetEntity = User::class, cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private var present: User? = null


    @OneToMany(mappedBy = "manga", fetch = FetchType.LAZY, targetEntity = MediaGhost::class)
    val media: List<MediaGhost> = mutableListOf()
}


