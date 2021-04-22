package com.example.projectespringbootsecurity.ConfiguracioSeguretat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfiguracioSeguretet extends WebSecurityConfigurerAdapter {
    @Autowired
    private ControllerUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/sectes/list","/register/*","/user/*","/user/new/submit","/ordenar/nom","/updateSecta","/h2-console/**").permitAll()
                .antMatchers("/sectes/edit/submit","/sectes/eliminar","/sectes/new","sectes/new/submit").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.csrf().disable(); //per h2-console
        http.headers().frameOptions().disable(); //per h2-console

    }

}