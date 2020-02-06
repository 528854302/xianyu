package com.xianyu.config;

import com.xianyu.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailService;
    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new  BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/portal/signup","/portal/upload","/portal/img/**","/portal/css/**",
                "/portal/js/**","/portal/checkUser","/api/**"
                ,"/portal/login","/portal/index","/portal/pinfo")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/portal/login")
                .loginProcessingUrl("/portal/checkUser").defaultSuccessUrl("/portal/index",true)
                .and().csrf().disable()
                .logout().logoutUrl("/portal/logout").logoutSuccessUrl("/portal/index");
    }
}
