package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.lang.NonNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.domain.`object`.Credential
import sho0126hiro.DiaryShareBackend.domain.repository.CredentialRepository
import sho0126hiro.DiaryShareBackend.infrastructure.repository.CredentialRepositoryImpl

@Service
class CredentialService (
        private val credentialRepository: CredentialRepository
){
    fun register(credential: Credential){
        credential.encrypt(BCryptPasswordEncoder())
        println(credential)
        credentialRepository.create(credential)
    }
}