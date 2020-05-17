package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.application.resource.UserSearchResult
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import java.util.*

data class User (
        val id: UUID? = null,
        val username: String? = null,
        val name: String? = null,
        val email: String? = null,
        val bio: String? = null
){
    fun credentialToEntity(): UserEntity {
        return UserEntity(
                username = requireNotNull(username),
                name = requireNotNull(name),
                email = requireNotNull(email)
        )
    }

    fun toBody(): UserBody {
        if(id !== null)
            return UserBody(
                id.toString(),
                username,
                name,
                email,
                bio)
        TODO("Error Handling")
    }

    fun toSearchResult(): UserSearchResult {
        return UserSearchResult(
                requireNotNull(username),
                requireNotNull(name),
                bio
        )
    }

}
