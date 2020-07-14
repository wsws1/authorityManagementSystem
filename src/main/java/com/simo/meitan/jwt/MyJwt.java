package com.simo.meitan.jwt;

import io.jsonwebtoken.*;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyJwt extends BasicAuthenticationFilter {
    private  static  Logger logger= LoggerFactory.getLogger(MyJwt.class);
    public MyJwt(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String jwtToken = request.getHeader("X-Token");
        System.out.println(jwtToken);
        UsernamePasswordAuthenticationToken token=null;
        String username=null;
        if (jwtToken != null ) {
            try {
                Claims claims = Jwts.parser().setSigningKey("sang@123").parseClaimsJws(jwtToken.replace("Bearer", ""))
                        .getBody();
                 username= claims.getSubject();//获取当前登录用户名
                System.out.println(username);
                List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
                System.out.println(authorities.get(0).getAuthority());

                token=new UsernamePasswordAuthenticationToken(username, null, authorities);
            }catch (Exception exception) {
                logger.debug("Request to parse JWT with invalid signature . Detail : " + exception.getMessage());
                SecurityContextHolder.clearContext();
                throw new Exception("token已经失效");

            }
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        chain.doFilter(request, response);
    }
}
