package com.duynb.spring.crud.Authencation;

import com.duynb.spring.crud.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.IllegalFormatException;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "yourSecretKey";
    private final long JWT_EXPIRATION = 604800000L;

    public String generateToken(CustomUserDetail userDetail){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(userDetail.getAccount().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.ES256,JWT_SECRET)
                .compact();
    }
    public Long getUserIdFromJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
    public Boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        }catch (JwtException je ){
            return false;
        }catch (IllegalArgumentException iae){
            return false;
        }
    }
}
