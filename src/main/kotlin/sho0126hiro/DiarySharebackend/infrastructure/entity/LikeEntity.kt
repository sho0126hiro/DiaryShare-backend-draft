package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import sho0126hiro.DiaryShareBackend.domain.`object`.Like
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "likes")
class LikeEntity (
        @Id
        @Column(name = "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        val userId: ByteArray,

        val diaryId: ByteArray,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null

){
    fun toDomainObject(): Like{
        return Like(
                userID = bytesToUuid(userId),
                diaryId = bytesToUuid(diaryId),
                createdAt = createdAt.toString()
        )
    }
}