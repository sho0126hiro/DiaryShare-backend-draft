package sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.LikeEntity
import java.util.*

interface LikeJpaRepository : JpaRepository<LikeEntity, String>{
    fun removeByUserIdAndDiaryId(userId: ByteArray, DiaryId: ByteArray)
}