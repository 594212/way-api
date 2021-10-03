package com.example.way.api.data.models

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TagModelKey(

        @Column(name = "model_id")
        var modelId: Long,

        @Column(name = "tag_id")
        var tagId: Long
) : Serializable