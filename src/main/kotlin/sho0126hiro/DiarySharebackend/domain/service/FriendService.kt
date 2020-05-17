package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.FriendBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.FriendRepository
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
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
        val friendId: UUID? = userRepository.findByUsername(friendUsername).id
        if(friendId != null) return friendId
        TODO()
    }

    fun create(friend: Friend): FriendBody{
        val friendId: UUID = getFriendId(friend.friendUsername)
        return friendRepository.create(
                friend.toEntity(friendId)
        ).toBody(friend.friendUsername)
    }

    fun changeStatus(friend: Friend): FriendBody{
        val friendId: UUID = getFriendId(friend.friendUsername)
        return friendRepository.changeStatus(
                friend.toEntity(friendId)
        ).toBody(friend.friendUsername)
    }

    fun delete(friend: Friend){
        val friendId: UUID = getFriendId(friend.friendUsername)
        friendRepository.delete(
                userId = friend.userId,
                friendId = friendId
        )
    }
}