package sho0126hiro.DiaryShareBackend.domain.`object`

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CredentialEntity

data class Credential (
        val username: String,
        var password: String
){
    fun toEntity(): CredentialEntity {
        return CredentialEntity(username,password)
    }
    fun encrypt(encoder: PasswordEncoder){
        password = encoder.encode(password)
    }
}