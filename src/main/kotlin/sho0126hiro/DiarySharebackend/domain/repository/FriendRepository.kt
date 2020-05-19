package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import java.util.*

interface FriendRepository {
    fun create(friendEntity: FriendEntity): Friend
    fun changeStatus(friendEntity: FriendEntity): Friend
    fun delete(userId: UUID, friendId: UUID)
    fun findPairByUserIdAndFriendId(friendEntity: FriendEntity): Pair<FriendEntity, FriendEntity>
}