package sho0126hiro.DiaryShareBackend.domain.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import sho0126hiro.DiaryShareBackend.domain.`object`.Credential
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CredentialEntity

interface CredentialRepository {
    // 認証情報追加
    @Autowired
    fun create(credential: Credential)
    // 認証情報LoginID検索
    fun findByLoginId(login_id: String): CredentialEntity?
}