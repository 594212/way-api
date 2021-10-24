package com.example.way.api.data.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@DiscriminatorValue("App\\Models\\Posts")
@Table(name = "posts")
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        override var id: Long = 0,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var author: User? = null,
        var image: String = "",
        var description: String = "",
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now())


) : HasMedia() {

        @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, targetEntity = Media::class)
        val media: Collection<Media> = mutableListOf()
}