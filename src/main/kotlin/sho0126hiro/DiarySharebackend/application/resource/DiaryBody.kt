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

/**
 * 利用者に紐づく日記一覧
 */
data class UserDiaryList(
        val userId: String, // リクエスト送信者
        val diaryList: List<UserDiary>
){
    data class UserDiary(
            val id: String,
            val status: String,
            val title: String,
            val content: String,
            val createdAt: String
    )
}