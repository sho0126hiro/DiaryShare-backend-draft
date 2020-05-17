package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.Credential
import sho0126hiro.DiaryShareBackend.domain.repository.CredentialRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CredentialEntity
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.CredentialJpaRepository

@Repository
class CredentialRepositoryImpl(
        val credentialJpaRepository: CredentialJpaRepository
): CredentialRepository {

    override fun create(credential: Credential) {
        credentialJpaRepository.save(credential.toEntity())
    }

    override fun findByLoginId(login_id: String): CredentialEntity? {
        return credentialJpaRepository.findById(login_id).orElse(null)
    }
}