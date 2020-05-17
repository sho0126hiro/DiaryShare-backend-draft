package sho0126hiro.DiaryShareBackend.application.validator

object Constant {
    object DiaryStatus {
        val DRAFT: String = "DRAFT"
        val RELEASED: String = "RELEASED"
        val PRIVATE: String =  "PRIVATE"
        val paramList = listOf<String>(DRAFT, RELEASED, PRIVATE)
    }
}