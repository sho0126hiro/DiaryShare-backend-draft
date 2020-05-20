package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.DiaryBody
import sho0126hiro.DiaryShareBackend.application.resource.UserDiaryList
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.`object`.DiaryList
import sho0126hiro.DiaryShareBackend.domain.repository.DiaryRepository
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity
import java.util.*

@Service
class DiaryService (
        val diaryRepository: DiaryRepository,
        val userRepository: UserRepository
){
    fun create(diary: Diary): DiaryBody{
        return diaryRepository.create(diary).toBody()
    }

    fun edit(diary: Diary): DiaryBody{
        return diaryRepository.edit(diary).toBody()
    }

    fun changeStatus(diary: Diary): DiaryBody {
        return diaryRepository.changeStatus(
                id = requireNotNull(diary.id),
                status = requireNotNull(diary.status)).toBody()
    }

    /**
     * 自分の日記を全て取得する
     */
    fun getAll(userId: String): UserDiaryList{
        val diaryEntityList: List<DiaryEntity> = userRepository.findById(
                UUID.fromString(userId)).getDiarySet().toList()
        return DiaryList(
                diaryEntityList.map{
                    it.toDomainObject()
                }
        ).toUserDiaryList(userId)
    }
}