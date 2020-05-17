package sho0126hiro.DiaryShareBackend.application.validator

object Constant {
    object DiaryStatus {
        val DRAFT: String = "DRAFT"
        val RELEASED: String = "RELEASED"
        val PRIVATE: String =  "PRIVATE"
        val paramList = listOf<String>(DRAFT, RELEASED, PRIVATE)
    }
    object FriendStatus {
        val APPLIED: String = "APPLIED" //申請中
        val ACCEPTED: String = "ACCEPTED" //許可中
        val BLOCK: String = "BLOCK" // ブロック中 => not implement
        val paramList = listOf<String>(APPLIED, ACCEPTED)
    }
}