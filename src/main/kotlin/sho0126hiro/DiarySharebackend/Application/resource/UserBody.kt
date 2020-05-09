package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.User

class UserBody (
        val id: String,
        val name: String? = null,
        val email: String? = null,
        val bio: String? = null
){
    fun toDomainObject(): User {
        return User(id,name,email,bio)
    }
}
