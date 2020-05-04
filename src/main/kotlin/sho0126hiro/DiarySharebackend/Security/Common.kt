package sho0126hiro.DiaryShareBackend.Security

object Common {
    val SERVER_SECRET: String = "secret"
    val TOKEN_EXPIRATION_MS: Int = 30 * 60 * 1000 // TOKENの有効期限(ms)
    object UserParam {
        val USERNAME_PARAMATER = "id"
        val PASSWORD_PARAMATER = "pass"
    }
    object Header{
        val TOKEN_PREFIX = "Bearer "
        val NAME = "Authorization"
    }
}

