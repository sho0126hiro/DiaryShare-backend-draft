package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository

@Service
class UserService (
        private val userRepository: UserRepository
){
    /**
     * ユーザの追加
     * @param user: User(id,email, null...)
     */
    fun create(user: User): UserBody {
        return userRepository.create(user).toUserBody()
    }

    /**
     * 名前の変更
     */
    fun updateName(user: User): UserBody {
        return userRepository.updateName(
                requireNotNull(user.id.toString()),
                requireNotNull(user.name)).toUserBody()
    }

    /**
     * bioの変更
     */
    fun updateBio(user: User): UserBody {
        return userRepository.updateBio(
                requireNotNull(user.id.toString()),
                requireNotNull(user.bio)).toUserBody()
    }
}