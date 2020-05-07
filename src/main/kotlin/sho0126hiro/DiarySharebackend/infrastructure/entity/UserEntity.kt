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
        private val id: Int,

        @Column(name = "name")
        private val name: String,

        @Column(name = "email")
        private val email: String,

        @Column(name = "created_at")
        @CreatedDate
        private val created_at: String,

        @Column(name = "updated_at")
        @LastModifiedDate
        private val updated_at: String
){
    fun toDomainUser(): User{
        return User(id.toString(),name,email)
    }
}