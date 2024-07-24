package com.duynb.spring.crud.authentication;

import com.duynb.spring.crud.constant.ConfigConstants;
import com.duynb.spring.crud.exception.NotFoundException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class JwtTokenProvider {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "lodaaaaaa";

    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 604800000L;

    /**
     * Tạo chuỗi JWT từ thông tin tài khoản người dùng
     * @param userDetails thông tin tài khoản người dùng
     * @return chuỗi JWT
     */
    public String generateToken(CustomUserDetails userDetails) {
        if(Objects.isNull(userDetails)){
            throw new IllegalArgumentException();
        }
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        System.out.println(expiryDate);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /**
     * Lấy id tài khoản người dùng từ chuỗi JWT
     * @param token chuỗi JWT
     * @return Id của tài khoản người dùng
     */
    public Long getUserIdFromJWT(String token) {
        if(Objects.isNull(token)){
            throw new IllegalArgumentException();
        }
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    /**
     * kiểm tra tính hợp lệ của token
     * @param authToken token JWT
     * @return True nếu hợp lệ, exception nếu không hợp lệ
     */
    public boolean validateToken(String authToken) {
        try {
            System.out.println(Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken));
            return true;
        } catch (MalformedJwtException ex) {
            throw new NotFoundException(ConfigConstants.INVALID_TOKEN_MESSAGE);
        } catch (ExpiredJwtException ex) {
            throw new NotFoundException(ConfigConstants.EXPIRED_TOKEN_MESSAGE);
        } catch (UnsupportedJwtException ex) {
            throw new NotFoundException(ConfigConstants.UNSUPPORTED_TOKEN_MESSAGE);
        } catch (IllegalArgumentException ex) {
            throw new NotFoundException(ConfigConstants.EMPTY_TOKEN_MESSAGE);
        } catch (SignatureException ex){
            throw new NotFoundException(ConfigConstants.INVALID_SIGNATURE_MESSAGE);
        }
    }
}
