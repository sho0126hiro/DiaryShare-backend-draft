package sho0126hiro.DiaryShareBackend.security.filter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import sho0126hiro.DiaryShareBackend.application.resource.CredentialInfo
import sho0126hiro.DiaryShareBackend.security.Common
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.collections.ArrayList

/**
 * 認証を実装するフィルタ
 */
class JWTAuthenticationFilter (
        private val authenticationManager_: AuthenticationManager,
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
): UsernamePasswordAuthenticationFilter() {
    init {
        // ログイン用のpathを設定
        setRequiresAuthenticationRequestMatcher(AntPathRequestMatcher("/credential/get", "POST"))
        usernameParameter = Common.UserParam.USERNAME_PARAMATER
        passwordParameter = Common.UserParam.PASSWORD_PARAMATER
    }

    // 認証の処理
    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(req: HttpServletRequest,
                                       res: HttpServletResponse?): Authentication? {
        return try {
            // requestパラメータからユーザ情報を読み取る
            val user: CredentialInfo = jacksonObjectMapper().readValue<CredentialInfo>(req.inputStream,CredentialInfo::class.java)
            authenticationManager_.authenticate(
                    UsernamePasswordAuthenticationToken(
                            user.username,
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