package sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CredentialEntity

interface CredentialJpaRepository: JpaRepository<CredentialEntity, String>{
}