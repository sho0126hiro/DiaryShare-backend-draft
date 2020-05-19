package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.Like
import java.util.*

class LikeBody (
        val userId: String,
        val diaryId: String,
        val createdAt: String? = null
){
    fun toDomainObject(): Like {
        return Like(
                UUID.fromString(userId),
                UUID.fromString(diaryId)
        )
    }
}