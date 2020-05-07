package sho0126hiro.DiaryShareBackend.domain.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import sho0126hiro.DiaryShareBackend.domain.repository.CredentialRepository
import sho0126hiro.DiaryShareBackend.infrastructure.entity.CredentialEntity

@Service
class UserDetailsServiceImpl (
  private val credentialRepository: CredentialRepository
): UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        // dbで検索
        if(username == null) throw UsernameNotFoundException(username)
        val credential: CredentialEntity? = credentialRepository.findByLoginId(username)
        if(credential == null) throw UsernameNotFoundException(username)
        println(credential.login_id)
        println(credential.pass)
        return User.withUsername(credential.login_id)
                .password("{bcrypt}"+credential.pass)
                .roles("USER")
                .build()
    }
}