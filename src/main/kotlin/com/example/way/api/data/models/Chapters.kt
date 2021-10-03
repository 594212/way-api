package com.example.way.api.data.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "chapters")
class Chapters(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id :Long = 0,

        @get: NotBlank
        var volume: Long = -1,

        @get: NotBlank
        var chapter: Long = -1,
        var type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now())

)