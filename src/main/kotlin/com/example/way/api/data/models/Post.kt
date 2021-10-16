package com.example.way.api.data.models

import com.example.way.api.data.models.media.HasMedia
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "posts")
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var author: User? = null,
        var image: String = "",
        var description: String = "",
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now())

) : HasMedia