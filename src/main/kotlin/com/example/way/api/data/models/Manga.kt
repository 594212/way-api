package com.example.way.api.data.models

import com.example.way.api.extention.cyr2lat
import com.example.way.api.extention.toSlug
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@DiscriminatorValue("App\\Models\\Manga")
@Table(name = "mangas")
data class Manga(
    @Column(columnDefinition = "varchar(255) default 'empty-name'")
        val en_name: String = "",
    @Column(columnDefinition = "varchar(255) default ' '")
        val description: String = "",
    @Column(columnDefinition = "varchar(255) default 'В процессе'")
        val status: String = "",
    @Column(columnDefinition = "integer default 9999")
        val year: Int = 0,
    @Column(columnDefinition = "varchar(255) default 'неизвестно'")
        val language: String = "",
    @Column(columnDefinition = "varchar(255) default 'неизвестно'")
        val author: String = "",

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,
    @get: NotBlank
        val name: String = "",
    @Column(columnDefinition = "boolean default false")
        val type: Boolean = false,
    @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),
) : HasMedia()  {
    val slug: String =  "${name.cyr2lat().toSlug()}$id"

    @OneToMany(mappedBy = "manga", targetEntity = Chapter::class,
            cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val chapters: List<Chapter> = mutableListOf()

//    @OneToOne(targetEntity = User::class, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private val present: User = User()


    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, targetEntity = Media::class)
    val media: Collection<Media> = mutableListOf()
}


