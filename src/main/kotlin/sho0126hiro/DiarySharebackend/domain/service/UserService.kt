package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.repository.UserRepository
import sho0126hiro.DiaryShareBackend.exception.RequestException

@Service
class UserService (
        private val userRepository:UserRepository
){
    fun findById(id: String): User {
        val u = userRepository.findById(id)
        if(u != null) return u
        return User(0,"no")
    }
    fun save(user: User): User? {
        return userRepository.save(user)
    }
    fun deleteById(id: String) {
        userRepository.deleteById(id)
    }

}