package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import java.util.*

class User(
        private val id: Int,
        private val name: String
){
    fun toEntity(): UserEntity {
        return UserEntity(
                id = id, name = name, created_at = Date(), updated_at = Date()
        )
    }
}