package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.Comment
import java.util.*

class CommentBody (
        val id: String? = null,
        val userId: String,
        val diaryId: String,
        val content: String,
        val createdAt: String? = null
){
    fun toDomainObject(): Comment {
        var uuidCommentId: UUID? = null
        if(id != null) uuidCommentId = UUID.fromString(id)
        return Comment(
                id = uuidCommentId,
                userId = UUID.fromString(userId),
                diaryId = UUID.fromString(diaryId),
                content = content
        )
    }
}