package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.DiaryBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.repository.DiaryRepository

@Service
class DiaryService (
        val diaryRepository: DiaryRepository
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
}