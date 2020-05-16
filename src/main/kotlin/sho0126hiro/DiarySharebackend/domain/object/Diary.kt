package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.DiaryBody
import sho0126hiro.DiaryShareBackend.infrastructure.entity.DiaryEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

data class Diary (
        val id: UUID? = null,
        val userId: UUID,
        val status: String? = null,
        val title: String? = null,
        val content: String? = null,
        val createdAt: String? = null
){
    fun toBody(): DiaryBody {
        return DiaryBody(
                id.toString(), userId.toString(), status, title, content, createdAt
        )
    }
    fun toEntity(): DiaryEntity {
        return DiaryEntity(
                userId = uuidToBytes(userId),
                status = requireNotNull(status),
                title = requireNotNull(title),
                content = requireNotNull(content)
        )
    }
}