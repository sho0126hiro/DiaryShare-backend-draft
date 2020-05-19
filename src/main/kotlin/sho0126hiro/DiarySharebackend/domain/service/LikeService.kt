package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.LikeBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Like
import sho0126hiro.DiaryShareBackend.domain.repository.LikeRepository
import javax.transaction.Transactional

@Service
@Transactional
class LikeService (
        val likeRepository: LikeRepository
){
    fun create(like: Like): LikeBody {
        return likeRepository.create(like).toBody()
    }
    fun delete(like: Like){
        likeRepository.delete(like)
    }
}