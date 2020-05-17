package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.application.validator.Constant
import sho0126hiro.DiaryShareBackend.application.validator.FriendStatusValidator
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import java.util.*

class FriendBody(
        val userId: String,   // リクエスト送信者のid
        val friendUsername: String, // 相手のusername
        @field:FriendStatusValidator
        val status: String = Constant.FriendStatus.APPLIED,
        val createdAt: String? = null,
        val updatedAt: String? = null
) {
    fun toDomainObject(): Friend{
        return Friend(
                userId = UUID.fromString(userId),
                friendUsername = friendUsername,
                status = status
        )
    }
}