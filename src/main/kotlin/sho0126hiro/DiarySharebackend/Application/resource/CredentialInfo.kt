package sho0126hiro.DiaryShareBackend.application.resource

import org.springframework.security.crypto.password.PasswordEncoder
import sho0126hiro.DiaryShareBackend.domain.`object`.Credential
import sho0126hiro.DiaryShareBackend.domain.`object`.User

data class CredentialInfo (
        val email: String,
        var pass: String,
        val name: String
){

    fun toDomainObject(): Credential{
        return Credential(email,pass)
    }

    fun toUser(): User{
        return User(name,email)
    }
}