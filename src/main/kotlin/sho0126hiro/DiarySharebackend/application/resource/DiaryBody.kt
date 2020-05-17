package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.application.validator.DiaryStatusValidator
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import java.util.*

data class DiaryBody (
        val id: String? = null,
        val userId: String,

        @field:DiaryStatusValidator
        val status: String? = null, // DRAFT or RELEASED or PRIVATE
        val title: String? = null,
        val content: String? = null,
        val createdAt: String? = null
) {
    fun toDomainObject(): Diary {
        var uuidDiaryId: UUID? = null
        if(id != null) uuidDiaryId = UUID.fromString(id)
        return Diary(
                id = uuidDiaryId,
                userId = UUID.fromString(userId),
                status = status,
                title = title,
                content = content
        )
    }

}