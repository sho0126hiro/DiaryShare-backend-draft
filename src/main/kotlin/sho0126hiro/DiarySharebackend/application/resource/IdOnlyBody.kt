package sho0126hiro.DiaryShareBackend.application.resource

/**
 * idのみのリクエスト
 * 何かのIDだけをリクエストボディに持つ物
 * 主に検索などの処理に使用する
 */
class IdOnlyBody (
        val id: String
)