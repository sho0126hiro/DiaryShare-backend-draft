package sho0126hiro.DiaryShareBackend.Security

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*

class UserDetailServiceImpl : UserDetailsService{
    private val usernameList: List<String> = Arrays.asList("nyasba", "admin")
    private val ENCRYPTED_PASSWORD = "$2a$10$5DF/j5hHnbeHyh85/0Bdzu1HV1KyJKZRt2GhpsfzQ8387A/9duSuq" // "password"を暗号化した値

    override fun loadUserByUsername(username: String?): UserDetails {
        if(!usernameList.contains(username)){
            throw UsernameNotFoundException(username);
        }
        return User.withUsername(username).password("hogehoge")
                .authorities("ROLE")
                .build()
    }

}