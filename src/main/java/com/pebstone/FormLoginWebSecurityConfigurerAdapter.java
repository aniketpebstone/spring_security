package com.pebstone;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                
                .antMatchers("/trace","/css/**").permitAll()                    
                .antMatchers("/secure**").hasRole("ADMIN") 
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
            .httpBasic();                                                
  
    }
}
