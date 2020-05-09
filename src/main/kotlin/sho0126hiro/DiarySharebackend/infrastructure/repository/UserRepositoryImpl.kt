package sho0126hiro.DiaryShareBackend.infrastructure.repository

import org.springframework.stereotype.Repository
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.UserEntity
import sho0126hiro.DiaryShareBackend.infrastructure.repository.jpaRepository.UserJpaRepository

@Repository
class UserRepositoryImpl (
        val userJpaRepository: UserJpaRepository
): UserRepository {

    override fun create(user: User): User {
        return userJpaRepository.save(user.credentialToEntity()).toDomainUser()
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun updateName(id: String, name: String): User {
        val user: UserEntity? = userJpaRepository.findById(id.toInt()).orElse(null)
        if(user != null){
            user.setName(name)
            return userJpaRepository.save(user).toDomainUser()
        }
        TODO("Error Handling")

    }

    override fun updateBio(id: String, biography: String): User {
        val user: UserEntity? = userJpaRepository.findById(id.toInt()).orElse(null)
        if(user != null){
            user.setBiography(biography)
            return userJpaRepository.save(user).toDomainUser()
        }
        TODO("Error Handling")
    }
}