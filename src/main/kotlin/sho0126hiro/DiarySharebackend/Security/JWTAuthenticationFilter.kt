package sho0126hiro.DiaryShareBackend.Security

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import sho0126hiro.DiaryShareBackend.Security.resource.AuthRequest
import sho0126hiro.DiaryShareBackend.application.resource.UserBody
import java.io.IOException
import java.time.LocalDateTime
import java.util.*
import javax.naming.AuthenticationException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(
        authenticationManager: AuthenticationManager,
        bCryptPasswordEncoder: BCryptPasswordEncoder
): UsernamePasswordAuthenticationFilter() {

    init{
        setRequiresAuthenticationRequestMatcher(AntPathRequestMatcher("/login", "POST"))
        usernameParameter = Common.UserParam.USERNAME_PARAMATER
        passwordParameter = Common.UserParam.PASSWORD_PARAMATER
    }

    // 認証の処理
    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(req: HttpServletRequest,
                                       res: HttpServletResponse?): Authentication? {
        return try {
            // requestパラメータからユーザ情報を読み取る
            val user: AuthRequest = ObjectMapper().readValue(req.inputStream, AuthRequest::class.java)
            authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken(
                            user.id,
                            user.pass,
                            ArrayList())
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    // 認証に成功した場合の処理
    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(req: HttpServletRequest?,
                                          res: HttpServletResponse,
                                          chain: FilterChain?,
                                          auth: Authentication) {
        val token: String = Jwts.builder()
                .setSubject((auth.principal as User).username)
                .setExpiration(Date(System.currentTimeMillis()+ Common.TOKEN_EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS512, Common.SERVER_SECRET.toByteArray())
                .compact()
        res.addHeader(Common.Header.NAME, Common.Header.TOKEN_PREFIX + token)
    }
}