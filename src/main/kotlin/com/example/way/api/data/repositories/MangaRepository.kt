package com.example.way.api.data.repositories

import com.example.way.api.data.models.Manga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MangaRepository : CrudRepository<Manga,Long> {
//    fun findMangaByName(name: String): List<PostView>

}


//interface UserView {
//    val id: Long
//    val name: String?
//}
//interface PostView {
//    val id: Long
//    val name: String?
//    val user: UserView?
//}
