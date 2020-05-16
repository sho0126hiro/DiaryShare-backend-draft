package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.CommentBody
import sho0126hiro.DiaryShareBackend.application.validator.DiaryStatusValidator
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CommentEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

class Comment (
        val id: UUID? = null,
        val userId: UUID,
        val diaryId: UUID,
        val content: String,
        val createdAt: String? = null
){
    fun toBody(): CommentBody {
        return CommentBody(
                id.toString(),
                userId.toString(),
                diaryId.toString(),
                content,
                createdAt
        )
    }
    fun toEntity(): CommentEntity {
        return CommentEntity(
                userId = uuidToBytes(userId),
                diaryId = uuidToBytes(diaryId),
                content = content
        )
    }
}
