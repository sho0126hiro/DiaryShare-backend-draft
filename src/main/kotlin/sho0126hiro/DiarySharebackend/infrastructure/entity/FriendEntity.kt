package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "friends")
class FriendEntity(

        @Id
        @Column(name = "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        @Column(name = "user_id")
        val userId: ByteArray,

        @Column(name = "friend_id")
        val friendId: ByteArray,

        @Column(name = "status")
        private var status: String,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null
) {

    fun toDomainObject(): Friend {
        return Friend(
                bytesToUuid(userId),
                "", // input data at service layer
                status,
                createdAt.toString(),
                updatedAt.toString()
        )
    }

    fun setStatus(status: String){
        this.status = status
    }

    fun getStatus(): String{
        return this.status
    }
}