package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.DiaryBody
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity

data class Diary (
        val id: String? = null,
        val userId: String,
        val status: String? = null,
        val title: String? = null,
        val content: String? = null,
        val createdAt: String? = null
){
    fun toDiaryBody(): DiaryBody {
        return DiaryBody(
                id, userId, status, title, content, createdAt
        )
    }
    fun toEntity(): DiaryEntity{
        return DiaryEntity(
                userId = userId.toInt(),
                status = requireNotNull(status),
                title = requireNotNull(title),
                content = requireNotNull(content)
        )
    }
}