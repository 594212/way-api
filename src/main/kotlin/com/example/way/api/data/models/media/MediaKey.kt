package com.example.way.api.data.models

import com.example.way.api.data.models.media.HasMedia
import org.hibernate.annotations.Any
import org.hibernate.annotations.AnyMetaDef
import org.hibernate.annotations.ManyToAny
import org.hibernate.annotations.MetaValue
import java.io.Serializable
import javax.persistence.*

@Embeddable
@AnyMetaDef(name = "metaDef_model_type", metaType = "string", idType = "long",
        metaValues = [ MetaValue(value = "App\\Model\\Chapter", targetEntity = Chapter::class),
                MetaValue(value = "App\\Model\\Manga", targetEntity = Manga::class)])
@Entity
data class MediaKey(

//        @Column(name = "media_id", insertable = false, updatable = false )
//        val modelId : Long,
//        @Column(name = "model_type", insertable = false, updatable = false )
//        val modelType : String
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @ManyToAny(metaColumn = Column(name = "model_type"), metaDef = "metaDef_model_type")
        @JoinTable(name = "media_model", joinColumns = arrayOf(JoinColumn(name = "media_id",
                foreignKey = ForeignKey(name="media_model_type_model_id_index")
        )), inverseJoinColumns = arrayOf(JoinColumn(name = "media_id")))
        val models :List<HasMedia>? = null
        ): Serializable