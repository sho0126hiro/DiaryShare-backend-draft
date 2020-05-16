package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import java.util.*

data class User (
        val id: UUID? = null,
        val name: String? = null,
        val email: String? = null,
        val bio: String? = null
){
    fun credentialToEntity(): UserEntity {
        if(name != null && email != null) {
            return UserEntity(name= name, email=email)

        }
        TODO("Error Handling")
    }

    fun toUserBody(): UserBody {
        if(id !== null) return UserBody(id.toString(),name,email,bio)
        TODO("Error Handling")
    }

}
