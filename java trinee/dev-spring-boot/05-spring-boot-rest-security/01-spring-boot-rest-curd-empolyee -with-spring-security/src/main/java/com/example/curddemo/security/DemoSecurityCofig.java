package com.example.curddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityCofig {
/*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    UserDetails user = User.builder()
            .username("jhon")
            .password("{noop}123")
            .roles("Employee")
            .build();
    UserDetails user2=User.builder()
            .username("marry")
            .password("{noop}123")
            .roles("Employee","Manager")
            .build();
    UserDetails user3=User.builder()
            .username("susan")
            .password("{noop}123")
            .roles("Employee","Manager","Admin")
            .build();
    return new InMemoryUserDetailsManager(user,user2,user3);
}*/
//NO MORE HARD CODE
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource) {
    return new JdbcUserDetailsManager(dataSource);
}
@Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(Configurer->Configurer
        .requestMatchers(HttpMethod.GET,"/api/info").hasRole("EMPLOYEE")
            .requestMatchers(HttpMethod.GET,"/api/info/**").hasRole("EMPLOYEE")
            .requestMatchers(HttpMethod.POST,"/api/info").hasRole("MANAGER")
            .requestMatchers(HttpMethod.PUT,"/api/info").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/info/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PATCH,"/api/info/**").hasRole("MANAGER")
            .requestMatchers(HttpMethod.DELETE,"/api/info/**").hasRole("ADMIN")
            .anyRequest().authenticated()
    );

    //USE HTTP BASIC AUTHORIZATION
    http.httpBasic(Customizer.withDefaults());
    //DISABLE CROSS SITE REQUEST FORGERY (CSRF)
    http.csrf(csrf -> csrf.disable());
    //IN GENERAL, NOT REQUIRED FOR STATELESS REST APIS

    return http.build();}
}
