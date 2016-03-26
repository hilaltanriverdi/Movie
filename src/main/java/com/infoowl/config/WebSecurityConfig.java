package com.infoowl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by hilal on 3/26/2016.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //hangi sayfaların ulaşılabilir oldugunun belirlenmesi
    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http
                .authorizeRequests()
                .antMatchers("/signup.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();



    }

}
