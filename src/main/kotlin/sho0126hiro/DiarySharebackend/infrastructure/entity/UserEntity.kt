package sho0126hiro.DiaryShareBackend.infrastructure.entity

import sho0126hiro.DiaryShareBackend.domain.`object`.User
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int,
    private val name: String,
    private var created_at: Date,
    private var updated_at: Date
) {
    fun toDomainUser(): User? {
        return User(
                id = id,
                name = name
        )
    }
}