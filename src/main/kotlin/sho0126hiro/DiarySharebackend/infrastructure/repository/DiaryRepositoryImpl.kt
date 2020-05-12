package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.repository.DiaryRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.DiaryJpaRepository

@Repository
class DiaryRepositoryImpl (
        val diaryJpaRepository: DiaryJpaRepository
): DiaryRepository {
    override fun create(diary: Diary): Diary {
        return diaryJpaRepository.save(diary.toEntity()).toDomainObject()
    }

    override fun edit(diary: Diary): Diary {
        if(diary.id != null) return diaryJpaRepository.save(diary.toEntity()).toDomainObject()
        println(diary.id)
        TODO("error handling")
        }

    override fun changeStatus(id: String, status: String): Diary {
        val diary: DiaryEntity? = diaryJpaRepository.findById(id.toInt()).orElse(null)
        if(diary != null) {
            diary.setStatus(status)
            return diaryJpaRepository.save(diary).toDomainObject()
        }
        TODO("Error Handling")
    }
}