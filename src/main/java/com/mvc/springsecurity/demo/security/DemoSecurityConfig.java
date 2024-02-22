package com.mvc.springsecurity.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails vivek = User.builder()
                .username("vivek")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails sunil = User.builder()
                .username("sunil")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
               // .roles("EMPLOYEE, MANAGER")    // It will give run time error, white label
                .build();
        UserDetails gopesh = User.builder()
                .username("gopesh")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(vivek, sunil, gopesh);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(logout->logout.permitAll()
                );

//        http.formLogin(Customizer.withDefaults());
        return http.build();
    }
}
