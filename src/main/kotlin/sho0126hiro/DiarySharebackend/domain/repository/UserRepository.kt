package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity

interface UserRepository {
    fun create(user: User): User
    fun getAll()
    fun updateName(id: String, name: String): User
    fun updateBio(id: String, biography: String): User
}