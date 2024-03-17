package com.epam.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers("/", "/info", "/loginSuccess", "/about")
                    .permitAll()
                    .requestMatchers("/guest")
                    .hasRole("GUEST")
                    .requestMatchers("/admin")
                    .hasRole("ADMIN")
                    .requestMatchers("/user")
                    .hasRole("USER")
                    .anyRequest()
                    .authenticated())
        .formLogin((form) -> form.loginPage("/login").failureUrl("/login?error").permitAll())
        .logout(
            (logout) ->
                logout
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/index")
                    .permitAll())
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public UserDetailsService users(DataSource dataSource) {
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  public GrantedAuthoritiesMapper authoritiesMapper() {
    SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
    authorityMapper.setConvertToUpperCase(true);
    return authorityMapper;
  }
}
