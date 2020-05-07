package sho0126hiro.DiaryShareBackend.security.filter

import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import sho0126hiro.DiaryShareBackend.security.Common
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 認可処理
 */
class JWTAuthorizationFilter(
        authenticationManager: AuthenticationManager
) : BasicAuthenticationFilter(authenticationManager) {

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        val header: String? = req.getHeader(Common.Header.NAME)
        if(header == null || !header.startsWith(Common.Header.TOKEN_PREFIX)) {
            chain.doFilter(req, res)
            return
        }
        val authentication: UsernamePasswordAuthenticationToken? = getAuthentication(req)
        SecurityContextHolder.getContext().authentication = authentication
        chain.doFilter(req,res)
    }

    private fun getAuthentication(req: HttpServletRequest): UsernamePasswordAuthenticationToken? {
        val token: String? = req.getHeader(Common.Header.NAME)
        if (token == null) return null
        val user: String = Jwts.parser()
                .setSigningKey(Common.SERVER_SECRET.toByteArray())
                .parseClaimsJws(token.replace(Common.Header.TOKEN_PREFIX,""))
                .body.subject
        if(user == null) return null
        return UsernamePasswordAuthenticationToken(user,null,ArrayList())
    }
}