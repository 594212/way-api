package com.example.way.api.data.models

import com.example.way.api.data.listener.UserListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size


@Entity
@DiscriminatorValue("App\\Models\\User")
@Table(name = "user")
@EntityListeners(UserListener::class)
data class User(
        @Column(unique = true)
        @Size(min = 2)
        val username: String = "",
        @Size(min = 11)
        @Pattern(regexp = "^[+]?[7,8]?[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$")
        val phoneNumber: String = "",
        @Size(min = 60, max = 60)
        var password: String = "",
        val status: String = "available",
        @Pattern(regexp = "\\A(activated|deactivated)\\z")
        val accoutStatus: String = "activated",
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        override val id: Long = 0,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),

        ) : HasMedia() {
    @OneToMany(mappedBy = "author", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, targetEntity = Post::class)
    private val sentPosts: Collection<Post> = mutableListOf()

        @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, targetEntity = Media::class)
        val media: Collection<Media> = mutableListOf()
}