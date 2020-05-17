package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho0126hiro.DiaryShareBackend.application.resource.CredentialInfo
import sho0126hiro.DiaryShareBackend.application.resource.ResponseBody
import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import sho0126hiro.DiaryShareBackend.domain.service.CredentialService
import sho0126hiro.DiaryShareBackend.domain.service.UserService
import javax.validation.Valid

@RestController
@RequestMapping("credential")
class  CredentialController (
        private val credentialService: CredentialService,
        private val userService: UserService
){
    @PostMapping("/register")
    fun register(@Valid @RequestBody credential: CredentialInfo): ResponseBody {
        credentialService.register(credential.toDomainObject())
        val body: UserBody = userService.create(credential.toUser())
        return ResponseBody("success", body)
    }
}