package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Like
import sho0126hiro.DiaryShareBackend.domain.repository.LikeRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.LikeJpaRepository

@Repository
class LikeRepositoryImpl (
        val likeJpaRepository: LikeJpaRepository
): LikeRepository{
    override fun create(like: Like): Like {
        return likeJpaRepository.save(like.toEntity()).toDomainObject()
    }

    override fun delete(like: Like){
        likeJpaRepository.removeByUserIdAndDiaryId(
                uuidToBytes(like.userID),
                uuidToBytes(like.diaryId)
        )
    }
}