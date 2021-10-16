package com.example.way.api.data.models.tag

import com.example.way.api.data.models.Manga
import com.example.way.api.data.models.Post
import org.hibernate.annotations.*
import org.hibernate.annotations.Any
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "hash_model")
data class TagModel(
        @EmbeddedId
        var id: TagModelKey? = null,

        @Any(metaColumn = Column(name = "model_type"))
        @AnyMetaDef(metaType = "string", idType = "long",
                metaValues = [MetaValue(value = "hashtag", targetEntity = Hashtag::class),
                    MetaValue(value = "genre", targetEntity = Genre::class)])
        @MapsId("modelId")
        @JoinColumn(name = "model_id",insertable = false, updatable = false)
        var model: kotlin.Any,

        @Any(metaColumn = Column(name = "tag_type"))
        @AnyMetaDef(metaType = "string", idType = "long",
                metaValues = [MetaValue(value = "manga", targetEntity = Manga::class),
                    MetaValue(value = "post", targetEntity = Post::class)])
        @MapsId("tagId")
        @JoinColumn(name = "tag_id",insertable = false, updatable = false)
        var tag: kotlin.Any,



//        @Id
//        var id : Long = 0,

//        @ManyToAny(metaColumn = Column(name = "model_type"))
//        @AnyMetaDef(metaType = "string", idType = "long",
//                metaValues = [MetaValue(value = "manga", targetEntity = Manga::class),
//                    MetaValue(value = "post", targetEntity = Post::class)])
//        @MapsId("tagId")
//        @JoinTable(name = "hash_model", joinColumns = arrayOf(JoinColumn(name = "model_id",insertable = false, updatable = false)),
//                inverseJoinColumns = arrayOf(JoinColumn(name = "tag_id")),)
//        var tags: MutableSet<Tag>? = null,
//
//        @ManyToAny(metaColumn = Column(name = "tag_type"))
//        @AnyMetaDef(metaType = "string", idType = "long",
//                metaValues = [MetaValue(value = "hashtag", targetEntity = Hashtag::class),
//                    MetaValue(value = "genre", targetEntity = Genre::class)])
//        @MapsId("modelId")
//        @JoinTable(name = "hash_model", joinColumns = arrayOf(JoinColumn(name = "tag_id", insertable = false, updatable = false)),
//                inverseJoinColumns = arrayOf(JoinColumn(name = "model_id")))
//        var models: MutableSet<Model>? = null
)