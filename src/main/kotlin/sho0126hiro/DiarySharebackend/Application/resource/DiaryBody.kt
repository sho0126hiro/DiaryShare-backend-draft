package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.application.validator.DiaryStatusValidator
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary

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
        return Diary(
                id = id,
                userId = userId,
                status = status,
                title = title,
                content = content,
                createdAt = createdAt
        )
    }

}