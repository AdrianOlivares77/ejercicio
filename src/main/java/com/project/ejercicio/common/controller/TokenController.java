package com.project.ejercicio.common.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.ejercicio.common.exception.JwtException;
import com.project.ejercicio.data.model.TokenModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class TokenController {

    @PostMapping("token")
    public TokenModel login(@RequestParam("user") String username) {

        try {
            String token = getJWTToken(username);
            TokenModel jwt = new TokenModel();
            jwt.setJwt(token);
            return jwt;
        } catch (Exception ex) {
            throw new JwtException(ex.getMessage(),ex);
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("JWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}