package sho0126hiro.DiaryShareBackend.application.resource
/**
 * レスポンス　共通クラス
 */
data class ResponseBody (
        val message: String,
        val payload: Any
)