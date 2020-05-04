package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository

@Repository
class UserRepositoryImpl(val userJpaRepository: UserJpaRepository) : UserRepository
{
    override fun findById(id: String): User? {
        return userJpaRepository.findById(id).get().toDomainUser()
    }

    override fun save(user: User): User? {
        return userJpaRepository.save(user.toEntity()).toDomainUser()
    }

    override fun deleteById(id: String) {
        userJpaRepository.deleteById(id)
    }
}