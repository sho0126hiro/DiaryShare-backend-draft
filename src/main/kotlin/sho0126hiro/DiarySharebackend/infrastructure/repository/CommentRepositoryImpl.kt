package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Comment
import sho0126hiro.DiaryShareBackend.domain.repository.CommentRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CommentEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.CommentJpaRepository

@Repository
class CommentRepositoryImpl (
        val commentJpaRepository: CommentJpaRepository
): CommentRepository{
    override fun create(comment: Comment): Comment {
        return commentJpaRepository.save(comment.toEntity()).toDomainObject()
    }

    override fun edit(comment: Comment): Comment {
        val c: CommentEntity = commentJpaRepository.findById(
                uuidToBytes(requireNotNull(comment.id))).orElse(null)
        if(c != null) {
            c.setContent(comment.content)
            return commentJpaRepository.save(c).toDomainObject()
        }
        TODO("Error Response")
    }
}