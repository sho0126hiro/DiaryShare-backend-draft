package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import sho0126hiro.DiaryShareBackend.domain.`object`.Comment
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "comments")
class CommentEntity (
        @Id
        @Column(name= "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        @Column(name = "user_id")
        private val userId: ByteArray,

        @Column(name = "diary_id")
        private val diaryId: ByteArray,

        @Column(name = "content")
        private var content: String,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null
){
        fun toDomainObject(): Comment{
                return Comment(
                        bytesToUuid(id),
                        bytesToUuid(userId),
                        bytesToUuid(diaryId),
                        content,
                        createdAt.toString()
                )
        }
        fun setContent(content: String){
                this.content = content
        }
}