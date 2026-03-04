package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hi").permitAll()
                .and()
                .authorizeRequests().antMatchers("/read").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/write").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();

    }


    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("Sergey")
                .password(encoder().encode("Password_1"))
                .authorities("read", "write")
                .and()
                .withUser("Elena")
                .password(encoder().encode("qwerty"))
                .authorities("read")
                .and()
                .withUser("Polina")
                .password("{noop}bluetractor")
                .authorities("write");

    }


}
