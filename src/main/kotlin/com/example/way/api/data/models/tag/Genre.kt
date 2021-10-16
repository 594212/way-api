package com.example.way.api.data.models.tag

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "genres")
data class Genre(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        @Column(unique = true)
        @Size(min = 2)
        var name: String = "")
