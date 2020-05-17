package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import sho0126hiro.DiaryShareBackend.domain.repository.FriendRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.FriendEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.FriendJpaRepository
import java.util.*

@Repository
class FriendRepositoryImpl(
        val friendJpaRepository: FriendJpaRepository
): FriendRepository {

    /**
     * 申請するユーザが入る
     * userId: 申請するユーザ, friendId: 申請されたユーザ
     */
    override fun create(friendEntity: FriendEntity): Friend{
        return friendJpaRepository.save(friendEntity).toDomainObject()
    }

    /**
     * 現状、申請されたユーザがここに入る
     * userId: 申請されたユーザ, friendId: 申請したユーザ
     * ---
     * ブロック機能を追加する場合, userId, friendIDのどちらが申請した側か判定する必要がある。
     * https://github.com/sho0126hiro/DiaryShare-backend/issues/22
     *
     */
    override fun changeStatus(friendEntity: FriendEntity): Friend{
        val f: FriendEntity? = friendJpaRepository.findByUserIdAndFriendId(
                userId = friendEntity.friendId,
                friendId = friendEntity.userId
        ).orElse(null)
        if(f != null){
            f.setStatus(friendEntity.getStatus())
            return friendJpaRepository.save(f).toDomainObject()
        }
        TODO("Error Handling")
    }

    /**
     * 申請者 userId, 相手: friendId
     */
    override fun delete(userId: UUID, friendId: UUID){
        var f: FriendEntity? = friendJpaRepository.findByUserIdAndFriendId(
                userId = uuidToBytes(friendId),
                friendId = uuidToBytes(userId)
        ).orElse(null)
        if(f != null) return friendJpaRepository.delete(f)
        f = friendJpaRepository.findByUserIdAndFriendId(
                userId = uuidToBytes(userId),
                friendId = uuidToBytes(friendId)
        ).orElse(null)
        if(f != null) return friendJpaRepository.delete(f)
        TODO()
    }

}