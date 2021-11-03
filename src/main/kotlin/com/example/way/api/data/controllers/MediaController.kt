package com.example.way.api.data.controllers

import com.example.way.api.components.MediaAssembler
import com.example.way.api.data.repositories.MediaRepository
import com.example.way.api.helpers.objects.MediaResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/medias")
class MediaController(
    val mediaRepository: MediaRepository,
    val mediaAssembler: MediaAssembler
) {

    @GetMapping
    fun getMedia(): List<MediaResponse> {
        return mediaRepository.findAll().map(mediaAssembler::toMediaResponse)
    }

}