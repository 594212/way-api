package com.example.way.api.data.models

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
        var en_name: String ="",
        var description: String = "",
        var status: String ="",
        var year: Int = 0,
        var language: String ="",
        var author: String = "",

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @get: NotBlank
        var name: String = "",
        var type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now())) {
    val slug get() = "${name.cyr2lat().toSlug()}$id"

    @OneToMany(mappedBy = "chapter", targetEntity = Chapters::class,
            cascade = arrayOf(CascadeType.ALL),fetch = FetchType.LAZY )
    private var chapters: Collection<Chapters> = mutableListOf()

    @OneToOne(targetEntity = User::class,cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private var present: User? = null
}


