package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class DemoConfiguration extends WebSecurityConfigurerAdapter {

    public static final String ROLE_READ = "READ";
    public static final String ROLE_WRITE = "WRITE";

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("Sergey")
                .password(encoder().encode("Password_1"))
                .roles(ROLE_READ, ROLE_WRITE)
                .and()
                .withUser("Elena")
                .password(encoder().encode("qwerty"))
                .roles(ROLE_READ)
                .and()
                .withUser("Polina")
                .password("{noop}bluetractor")
                .authorities("WRITE");

    }

}
