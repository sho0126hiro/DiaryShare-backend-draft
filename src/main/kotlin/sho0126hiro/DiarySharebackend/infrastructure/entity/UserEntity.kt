package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.properties.Delegates

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener::class)
class UserEntity(

        @Id
        @Column(name = "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        @Column(name = "name")
        private var name: String,

        /**
         * credentials.login_idと同じ
         */
        @Column(name = "email")
        private var email: String,

        @Column(name = "biography")
        private var biography: String? = null,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private var createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null

){
    fun toDomainUser(): User {
        return User(bytesToUuid(id), name, email, biography)
    }

    fun setName(name: String){
        this.name = name
    }

    fun setBiography(bio: String){
        this.biography = bio
    }
}