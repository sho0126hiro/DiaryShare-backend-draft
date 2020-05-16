package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.User
import java.util.*

data class UserBody (
        val id: String,
        val name: String? = null,
        val email: String? = null,
        val bio: String? = null
){
    fun toDomainObject(): User {
        return User(UUID.fromString(id),name,email,bio)
    }
}
