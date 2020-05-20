package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.repository.FriendRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.FriendJpaRepository
import java.util.*

@Repository
class FriendRepositoryImpl(
        val friendJpaRepository: FriendJpaRepository
): FriendRepository {

    /**
     * フレンド追加（申請中なども可能）
     * userId: 申請するユーザ, targetId: 申請されたユーザ
     * userId, targetIdは逆順でもDBに追加されます
     * （とりあえず取得処理が楽になるので）
     */
    override fun create(friendEntity: FriendEntity): Friend{
        return friendJpaRepository.save(friendEntity).toDomainObject()
    }


    override fun findPairByUserIdAndFriendId(friendEntity: FriendEntity): Pair<FriendEntity, FriendEntity>{
        val f1: FriendEntity? = friendJpaRepository.findByUserIdAndTargetUserId(
                userId = friendEntity.targetUserId, targetUserId = friendEntity.userId
        ).orElse(null)
        val f2: FriendEntity? = friendJpaRepository.findByUserIdAndTargetUserId(
                userId = friendEntity.userId, targetUserId = friendEntity.targetUserId
        ).orElse(null)
        if(f1 != null && f2 != null) return f1 to f2
        TODO("Error Handling")
    }
    
    /**
     * 'Block'Function does not implement
     * ACCEPT or APPLIED
     */
    override fun changeStatus(friendEntity: FriendEntity): Friend{
        val (f1: FriendEntity, f2: FriendEntity) = findPairByUserIdAndFriendId(friendEntity)
        f1.setStatus(friendEntity.getStatus())
        f2.setStatus(friendEntity.getStatus())
        friendJpaRepository.save(f2)
        return friendJpaRepository.save(f1).toDomainObject()
    }

    /**
     * リクエストをしたuserId, 相手: targetId
     */
    override fun delete(userId: UUID, friendId: UUID){
        var f: FriendEntity? = friendJpaRepository.findByUserIdAndTargetUserId(
                userId = uuidToBytes(friendId),
                targetUserId = uuidToBytes(userId)
        ).orElse(null)
        if(f != null) friendJpaRepository.delete(f)
        f = friendJpaRepository.findByUserIdAndTargetUserId(
                userId = uuidToBytes(userId),
                targetUserId = uuidToBytes(friendId)
        ).orElse(null)
        if(f != null) return friendJpaRepository.delete(f)
        TODO()
    }

}