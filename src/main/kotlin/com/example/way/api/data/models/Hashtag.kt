package com.example.way.api.data.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "hashtags")
data class Hashtag(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @Column(unique = true)
        @Size(min = 2)
        var name: String = "",
)