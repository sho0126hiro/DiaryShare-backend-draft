package sho0126hiro.DiaryShareBackend.domain.`object`

import sho0126hiro.DiaryShareBackend.application.resource.LikeBody
import sho0126hiro.DiaryShareBackend.infrastructure.entity.LikeEntity
import sho0126hiro.DiaryShareBackend.infrastructure.entity.uuidToBytes
import java.util.*

class Like (
        val userID: UUID,
        val diaryId: UUID,
        val createdAt: String? = null
){
    fun toEntity(): LikeEntity{
        return LikeEntity(
                userId = uuidToBytes(userID),
                diaryId =  uuidToBytes(diaryId)
        )
    }

    fun toBody(): LikeBody{
        return LikeBody(
                userId = userID.toString(),
                diaryId = diaryId.toString(),
                createdAt = createdAt
        )
    }
}