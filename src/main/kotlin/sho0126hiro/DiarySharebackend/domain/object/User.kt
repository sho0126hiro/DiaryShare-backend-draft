package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity

data class User (
        var id: String? = null,
        var name: String? = null,
        var email: String? = null
){
//    fun toEntity(): UserEntity{
//        return UserEntity(name= name, email=email)
//    }
}