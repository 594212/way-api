package com.example.way.api.data.models

import com.example.way.api.data.models.media.ModelType
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "media")
data class MediaGhost(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val name: String = "",
        @Column(name = "file_name")
        val fileName: String = "",
        @Column(name = "mime_type")
        val mimeType: String = "",
        val size : Long = 0,

        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),
        @DateTimeFormat
        val updatedAt: Date = Date.from(Instant.now()),

        @OneToOne(targetEntity = ModelType::class,
                fetch = FetchType.LAZY,cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "model_id")
        val model :ModelType

)
