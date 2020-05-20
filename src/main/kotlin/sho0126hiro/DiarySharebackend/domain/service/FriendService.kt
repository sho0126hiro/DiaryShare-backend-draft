package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.FriendBody
import sho0126hiro.DiaryShareBackend.application.resource.UserFriendList
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.`object`.FriendList
import sho0126hiro.DiaryShareBackend.domain.repository.FriendRepository
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

@Service
class FriendService (
        val friendRepository: FriendRepository,
        val userRepository: UserRepository
) {

    /**
     * friendのUsernameからUUIDを返す
     */
    private fun getFriendId(friendUsername: String): UUID {
        val targetId: UUID? = userRepository.findByUsername(friendUsername).id
        if(targetId != null) return targetId
        TODO()
    }

    fun create(friend: Friend): FriendBody{
        val targetId: UUID = getFriendId(friend.targetUsername)
        friendRepository.create(friend.toReverseEntity(targetId))
        return friendRepository.create(
                friend.toEntity(targetId)
        ).toBody(friend.targetUsername)
    }

    fun changeStatus(friend: Friend): FriendBody{
        val targetId: UUID = getFriendId(friend.targetUsername)
        return friendRepository.changeStatus(
                friend.toEntity(targetId)
        ).toBody(friend.targetUsername)
    }

    fun delete(friend: Friend){
        val targetId: UUID = getFriendId(friend.targetUsername)
        friendRepository.delete(
                userId = friend.userId,
                friendId = targetId
        )
    }

    /**
     * フレンドリストの取得
     */
    fun getFriendList(userId: String): UserFriendList {
        val friendEntityList: List<FriendEntity> = userRepository.findById(
                UUID.fromString(userId)).getFriendList()
        return FriendList(
                friendEntityList.map {
                    it.toDomainObjectWithTargetUserdata()
                }).toUserFriendList(userId)
    }

}