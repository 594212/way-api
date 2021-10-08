package com.example.way.api.data.models
import com.example.way.api.data.listener.UserListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size


@Entity
@Table(name ="`user`")
@EntityListeners(UserListener::class)
data class User (
        @Column(unique = true)
        @Size(min = 2)
        var username: String = "",
        @Size(min = 11)
        @Pattern(regexp="^[+]?[7,8]?[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$")
        var phoneNumber: String = "",
        @Size(min =60, max = 60)
        var password: String = "",
        var status: String = "available",
        @Pattern(regexp = "\\A(activated|deactivated)\\z")
        var accoutStatus: String = "activated",
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @DateTimeFormat
        val createdAt: Date = Date.from(Instant.now()),

) {
    @OneToMany(mappedBy = "author", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, targetEntity = Post::class)
    private var sentPosts: Collection<Post>? = null

    }