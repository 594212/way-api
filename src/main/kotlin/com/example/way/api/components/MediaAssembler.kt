package com.example.way.api.components

import com.example.way.api.data.models.Media
import com.example.way.api.helpers.objects.ListMediaVO
import com.example.way.api.helpers.objects.MediaVO
import org.springframework.stereotype.Component

@Component
class MediaAssembler {
    fun toMediaVO(media: Media): MediaVO {
        return MediaVO(media.id, media.name, media.fileName, media.mimeType,
                media.size, media.createdAt.toString(), media.updatedAt.toString())
    }

    fun toMediaListVO(list: List<Media>): ListMediaVO {
        val listMediaVO = list.map { toMediaVO(it) }
        return ListMediaVO(listMediaVO)

    }
}