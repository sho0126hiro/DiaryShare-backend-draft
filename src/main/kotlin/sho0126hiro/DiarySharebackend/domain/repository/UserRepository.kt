package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import java.util.*

interface UserRepository {
    fun create(user: User): User
    fun getAll()
    fun updateName(id: UUID, name: String): User
    fun updateBio(id: UUID, biography: String): User
}