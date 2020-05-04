package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity

interface UserJpaRepository: JpaRepository<UserEntity, String> {

}