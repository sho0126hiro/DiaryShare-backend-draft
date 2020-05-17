package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.application.resource.CommentBody
import sho0126hiro.DiaryShareBackend.domain.`object`.Comment
import sho0126hiro.DiaryShareBackend.domain.repository.CommentRepository

@Service
class CommentService (
        val commentRepository: CommentRepository
){
    fun create(comment: Comment): CommentBody {
        return commentRepository.create(comment).toBody()
    }

    fun edit(comment: Comment): CommentBody {
        return commentRepository.edit(comment).toBody()
    }
}