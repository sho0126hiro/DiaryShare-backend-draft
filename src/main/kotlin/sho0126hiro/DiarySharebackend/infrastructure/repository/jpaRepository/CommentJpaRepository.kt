package sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CommentEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity
import java.util.*

interface CommentJpaRepository: JpaRepository<CommentEntity, String> {
    fun findById(id: ByteArray): Optional<CommentEntity>
}