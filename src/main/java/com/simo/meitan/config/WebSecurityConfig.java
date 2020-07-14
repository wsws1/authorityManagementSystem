package com.simo.meitan.config;

import com.simo.meitan.expection.JwtAccessDeniedHandler;
import com.simo.meitan.expection.JwtAuthenticationEntryPoint;
import com.simo.meitan.jwt.JwtLoginFilter;
import com.simo.meitan.jwt.MyJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static cn.hutool.core.util.BooleanUtil.and;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("AdminUserServiceImpl")
    private UserDetailsService AdminUserServiceImpl;


    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /** 放行静态资源 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**")
         .antMatchers("/js/**")
        .antMatchers("/image/**")
        .antMatchers("/login/**")
        .antMatchers("/file/**")
        .antMatchers("/resources/**")
                .antMatchers("/index.html")
        .antMatchers("/static/css/**")
        .antMatchers("/static/js/**")
        .antMatchers("/static/img/**")
        .antMatchers("/static/fonts/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new JwtLoginFilter("/user/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new MyJwt(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and()
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler())
                .and()
                .authorizeRequests()
                .antMatchers("/book/*").hasRole("admin")
                .antMatchers("/organ/*").hasRole("admin")
                .antMatchers("/user/*").hasRole("editor")
                .antMatchers("/user/login").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(AdminUserServiceImpl).passwordEncoder(passwordEncoder());
    }







}
