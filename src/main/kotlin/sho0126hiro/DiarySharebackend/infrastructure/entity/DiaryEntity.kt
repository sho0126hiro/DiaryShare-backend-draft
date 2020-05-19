package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "diaries")
@EntityListeners(AuditingEntityListener::class)
class DiaryEntity (
        @Id
        @Column(name = "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        @Column(name = "user_id")
        private val userId: ByteArray,

        @Column(name = "status")
        private var status: String,


        @Column(name = "title")
        private var title: String,

        @Column(name = "content")
        private var content: String,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null

){
    fun toDomainObject(): Diary {
        return Diary(
                bytesToUuid(id), bytesToUuid(userId), status, title, content, createdAt.toString()
        )
    }

    fun setStatus(status: String){
        this.status = status
    }
    fun setTitle(title: String){
        this.title = title;
    }
    fun setContent(content: String){
        this.content = content
    }


}
