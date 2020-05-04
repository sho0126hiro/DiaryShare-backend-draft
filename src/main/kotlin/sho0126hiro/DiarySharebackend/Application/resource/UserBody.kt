package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.User

class UserBody (
        val id: String,
        val name: String
){
    fun toDomainUser(): User{
        return User(id = id.toInt(), name = name)
    }
}