package sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import java.util.*

interface FriendJpaRepository: JpaRepository<FriendEntity, String> {
    fun findByUserIdAndFriendId(userId: ByteArray, friendId: ByteArray): Optional<FriendEntity>
}