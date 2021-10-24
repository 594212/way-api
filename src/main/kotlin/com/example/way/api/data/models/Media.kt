package com.example.way.api.data.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER,
name = "model_type",columnDefinition = "varchar(255)")
data class Media(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne(fetch = FetchType.LAZY)
    val model: HasMedia = Manga()


) {
}



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class HasMedia() {
    @Id
    open val id: Long = 0

}