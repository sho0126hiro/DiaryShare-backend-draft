package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.`object`.User
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

        @Column(name = "target_user_id")
        val targetUserId: ByteArray,

        @Column(name = "status")
        private var status: String,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null,

        @ManyToOne
        @JoinColumn(referencedColumnName = "id", name = "target_user_id", insertable = false, updatable = false)
        var targetUserEntity: UserEntity? = null

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

    private fun targetUserEntityToDomainObject(): User{
        if(targetUserEntity != null) return targetUserEntity!!.toDomainUser()
        TODO("Error Handling this")
    }

    fun toDomainObjectWithTargetUserdata(): Friend{
        return Friend(
                bytesToUuid(userId),
                "", // input data at service layer
                status,
                createdAt.toString(),
                updatedAt.toString(),
                targetUserdata = targetUserEntityToDomainObject()
        )
    }

    fun setStatus(status: String){
        this.status = status
    }

    fun getStatus(): String{
        return this.status
    }
}
