package nl.knaw.dans.test

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{ EnableWebSecurity, WebSecurityConfigurerAdapter }
import org.springframework.security.core.userdetails.{ User, UserDetailsService }
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests
      .anyRequest.hasRole("ADMIN")
      .and
      .httpBasic
  }


  @Bean
  override def userDetailsService(): UserDetailsService = {
    new InMemoryUserDetailsManager() {
      createUser(User.withDefaultPasswordEncoder().username("admin").password("secret").roles("ADMIN").build())
      createUser(User.withDefaultPasswordEncoder().username("user").password("user").roles().build())
    }
  }
}
