package sho0126hiro.DiaryShareBackend.Security.controller

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho0126hiro.DiaryShareBackend.Security.resource.AuthRequest
import javax.validation.Valid


@RestController
@RequestMapping(path = ["/users"])
class CredentialController (
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
){
    @GetMapping("/private-api")
    fun api(): String {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        // JWTAuthenticationFilter#successfulAuthenticationで設定したusernameを取り出す
        return "this is private for ${authentication.getPrincipal()}"
    }

    @GetMapping("/create")
    fun create(@Valid @RequestBody user: AuthRequest): String {
        // passwordを暗号化する
        user.encrypt(bCryptPasswordEncoder);
        //　登録処理（DB）
        return "success"
    }
}


