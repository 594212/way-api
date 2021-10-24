package com.example.way.api.data.controllers

import com.example.way.api.components.MediaAssembler
import com.example.way.api.data.models.Media
import com.example.way.api.data.repositories.MediaRepository
import com.example.way.api.helpers.objects.ListMediaVO
import com.example.way.api.helpers.objects.MediaVO
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/medias")
class MediaController(val mediaRepository: MediaRepository,
                      val mediaAssembler: MediaAssembler) {

    @GetMapping
    fun getMedia(httpServletRequest: HttpServletRequest): ResponseEntity<ListMediaVO>? {
            val medias : ArrayList<Media> = ArrayList()
            medias.addAll(mediaRepository.findAll())
        return ResponseEntity.ok(mediaAssembler.toMediaListVO(medias))
        return null
    }
}