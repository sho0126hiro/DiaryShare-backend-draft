package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.FriendBody
import sho0126hiro.DiaryShareBackend.application.resource.UserFriendList
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

class Friend (
        val userId: UUID,
        val targetUsername: String,
        val status: String,
        val createdAt: String? = null,
        val updatedAt: String? = null,
        val targetUserdata: User? = null
) {
    fun toEntity(targetId: UUID): FriendEntity{
        return FriendEntity(
                userId = uuidToBytes(userId),
                targetUserId = uuidToBytes(targetId),
                status = status
        )
    }

    fun toReverseEntity(targetId: UUID): FriendEntity{
        return FriendEntity(
                userId = uuidToBytes(targetId),
                targetUserId = uuidToBytes(userId),
                status = status
        )
    }

    fun toBody(friendUsername: String): FriendBody{
        return FriendBody(
                userId = userId.toString(),
                targetUsername = friendUsername,
                status = status,
                createdAt = createdAt,
                updatedAt = updatedAt
        )
    }
}

/**
 * List<Friend>を扱う
 */
class FriendList(
        private val friendList: List<Friend>
){

    /**
     * userFriendList
     */
    fun toUserFriendList(userId: String): UserFriendList {
        val list = mutableListOf<UserFriendList.UserFriendListElement>()
        friendList.map{
            val user: User = requireNotNull(it.targetUserdata)
            list.add(
                    UserFriendList.UserFriendListElement(
                            targetUsername = requireNotNull(user.username),
                            targetName = requireNotNull(user.name),
                            status = it.status,
                            createdAt = requireNotNull(it.createdAt),
                            updateAt = requireNotNull(it.updatedAt)
                    )
            )
        }
        return UserFriendList(userId, list)
    }
}