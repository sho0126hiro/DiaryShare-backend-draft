package sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import java.util.*

interface UserJpaRepository: JpaRepository<UserEntity, String> {
    fun findById(id: ByteArray): Optional<UserEntity>
}