package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.Comment

interface CommentRepository {
    fun create(comment: Comment): Comment
    fun edit(comment: Comment): Comment
}