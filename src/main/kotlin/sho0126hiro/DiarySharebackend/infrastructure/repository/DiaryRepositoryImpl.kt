package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.repository.DiaryRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.DiaryJpaRepository
import java.util.*

@Repository
class DiaryRepositoryImpl (
        val diaryJpaRepository: DiaryJpaRepository
): DiaryRepository {
    override fun create(diary: Diary): Diary {
        return diaryJpaRepository.save(diary.toEntity()).toDomainObject()
    }

    override fun edit(diary: Diary): Diary {
        val d: DiaryEntity? = diaryJpaRepository.findById(uuidToBytes(requireNotNull(diary.id))).orElse(null)
        if(d != null) {
            d.setTitle(requireNotNull(diary.title))
            d.setContent(requireNotNull(diary.content))
            d.setStatus(requireNotNull(diary.status))
            return diaryJpaRepository.save(d).toDomainObject()
        }
        TODO("error handling")
    }

    override fun changeStatus(id: UUID, status: String): Diary {
        val diary: DiaryEntity? = diaryJpaRepository.findById(uuidToBytes(id)).orElse(null)
        if(diary != null) {
            diary.setStatus(status)
            return diaryJpaRepository.save(diary).toDomainObject()
        }
        TODO("Error Handling")
    }
}