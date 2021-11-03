package com.example.way.api.components

import com.example.way.api.data.models.Media
import com.example.way.api.helpers.objects.MediaResponse
import org.springframework.stereotype.Component

@Component
class MediaAssembler {
    fun toMediaResponse(media: Media): MediaResponse {
        return MediaResponse(id = media.id,
            name = media.name,
            fileName = media.fileName,
            mimeType = media.mimeType,
                size = media.size,
            createdAt = media.createdAt.toString(),
            updateAt = media.updatedAt.toString())
    }

}