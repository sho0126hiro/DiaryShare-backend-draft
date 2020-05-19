package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.application.resource.UserFriendList
import sho0126hiro.DiaryShareBackend.application.resource.UserSearchResult
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.`object`.FriendList
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import java.util.*

@Service
class UserService (
        private val userRepository: UserRepository
){
    /**
     * ユーザの追加
     * @param user: User(id,email, null...)
     */
    fun create(user: User): UserBody {
        return userRepository.create(user).toBody()
    }

    /**
     * 名前の変更
     */
    fun updateName(user: User): UserBody {
        return userRepository.updateName(
                requireNotNull(user.id),
                requireNotNull(user.name)).toBody()
    }

    /**
     * bioの変更
     */
    fun updateBio(user: User): UserBody {
        return userRepository.updateBio(
                requireNotNull(user.id),
                requireNotNull(user.bio)).toBody()
    }

    /**
     * usernameによる検索
     */
    fun findByUsername(username: String): UserSearchResult{
        return userRepository.findByUsername(
                username
        ).toSearchResult()
    }

    /**
     * フレンド一覧の取得
     */
    fun getFriendList(userId: String): UserFriendList {
        val friendEntityList: List<FriendEntity> = userRepository.getFriendList(
                UUID.fromString(userId)
        )
        return FriendList(
                friendEntityList.map {
                    it.toDomainObjectWithTargetUserdata()
                }).toUserFriendList(userId)
    }
}