package sho0126hiro.DiaryShareBackend.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import sho0126hiro.DiaryShareBackend.security.filter.JWTAuthenticationFilter
import sho0126hiro.DiaryShareBackend.security.filter.JWTAuthorizationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    private lateinit var userDetailsService: UserDetailsService
    protected override fun configure(http: HttpSecurity
    ) {
        http
                .cors()
                .and()
                .authorizeRequests()
                // antMatchersの引数のURLには認証の必要なし
                .antMatchers("credential/get", "/credential/register").permitAll()
                // それ以外は認証必要
                // developing mode
                .anyRequest().permitAll()
//                .anyRequest().authenticated()
                .and()
                // logout config
                .logout()
                .and()
                .csrf().disable()
                // 認証フィルター
                .addFilter(JWTAuthenticationFilter(authenticationManager(), bCryptPasswordEncoder()))
                // 認可フィルター
                .addFilter(JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    fun configureAuth(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder())
    }
}