package sho0126hiro.DiaryShareBackend.application.resource

import sho0126hiro.DiaryShareBackend.domain.`object`.User
import java.util.*

data class UserBody (
        val id: String,
        val username: String? = null,
        val name: String? = null,
        val email: String? = null,
        val bio: String? = null
){
    fun toDomainObject(): User {
        return User(UUID.fromString(id),username, name,email,bio)
    }
}

/**
 * 主に検索結果が格納される
 * userID, email, passwordのような個人情報は付与しない
 */
data class UserSearchResult(
        val username: String,
        val name: String,
        val bio: String?
)

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