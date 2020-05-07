package sho0126hiro.DiaryShareBackend.application.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho0126hiro.DiaryShareBackend.application.resource.CredentialInfo
import sho0126hiro.DiaryShareBackend.domain.service.CredentialService
import javax.validation.Valid

@RestController
@RequestMapping("credential")
class CredentialController (
        private val credentialService: CredentialService
){
    @PostMapping("/register")
    fun register(@Valid @RequestBody credential: CredentialInfo): String {
        credentialService.register(credential.toDomainObject())
        return "success"
    }
}