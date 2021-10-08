package com.example.way.api.data.models

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

        @get: NotBlank
        var volume: Int = -1,

        @get: NotBlank
        var chapter: Long = -1,
        @Column(columnDefinition = "boolean default false")
        var type: Boolean = false,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now())

)