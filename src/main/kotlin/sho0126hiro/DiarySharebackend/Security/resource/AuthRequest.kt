package sho0126hiro.DiaryShareBackend.Security.resource

import org.springframework.security.crypto.password.PasswordEncoder

class AuthRequest (
        val id: String,
        var pass: String
){
    fun encrypt(encoder: PasswordEncoder){
        this.pass = encoder.encode(pass)
    }
}
