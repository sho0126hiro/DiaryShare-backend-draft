package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.application.validator.Constant
import sho0126hiro.DiaryShareBackend.application.validator.FriendStatusValidator
import sho0126hiro.DiaryShareBackend.domain.`object`.Friend
import java.util.*

class FriendBody(
        val userId: String,   // リクエスト送信者のid
        val targetUsername: String, // 相手のusername
        @field:FriendStatusValidator
        val status: String = Constant.FriendStatus.APPLIED,
        val createdAt: String? = null,
        val updatedAt: String? = null
) {
    fun toDomainObject(): Friend{
        return Friend(
                userId = UUID.fromString(userId),
                targetUsername = targetUsername,
                status = status
        )
    }
}

/**
 * ユーザに紐づくフレンド一覧を返す
 */
data class UserFriendList(
        val userId: String, // リクエスト送信者のuserId
        val friendList: List<UserFriendListElement>
){
    /**
     * UserFrindListの要素
     */
    data class UserFriendListElement (
            val targetUsername: String,
            val targetName: String,
            val status: String,
            val createdAt: String,
            val updateAt: String
    )
}