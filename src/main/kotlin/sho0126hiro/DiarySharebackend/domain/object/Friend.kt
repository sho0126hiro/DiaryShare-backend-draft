package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.FriendBody
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

class Friend (
        val userId: UUID,
        val friendUsername: String,
        val status: String,
        val createdAt: String? = null,
        val updatedAt: String? = null
) {
    fun toEntity(friendId: UUID): FriendEntity{
        return FriendEntity(
                userId = uuidToBytes(userId),
                friendId = uuidToBytes(friendId),
                status = status
        )
    }

    fun toBody(friendUsername: String): FriendBody{
        return FriendBody(
                userId = userId.toString(),
                friendUsername = friendUsername,
                status = status,
                createdAt = createdAt,
                updatedAt = updatedAt
        )
    }
}