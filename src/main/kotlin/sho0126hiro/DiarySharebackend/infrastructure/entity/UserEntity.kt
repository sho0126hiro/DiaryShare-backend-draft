package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import java.util.*
import javax.persistence.*
import kotlin.properties.Delegates

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener::class)
data class UserEntity(

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Int? = null,

        @Column(name = "name")
        private var name: String,

        @Column(name = "email")
        private var email: String,

        @Column(name = "biography")
        private var biography: String? = null,

        @Column(name = "created_at")
        @CreatedDate
        private val created_at: String? = null,

        @Column(name = "updated_at")
        @LastModifiedDate
        private val updated_at: String? = null
){
    fun toDomainUser(): User {
        return User(id.toString(), name, email, biography)
    }

    fun setName(name: String){
        this.name = name
    }

    fun setBiography(bio: String){
        this.biography = bio
    }
}