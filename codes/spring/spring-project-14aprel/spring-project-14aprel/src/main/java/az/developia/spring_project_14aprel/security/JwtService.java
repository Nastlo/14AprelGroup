package az.developia.spring_project_14aprel.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String secretKey =
            "my-secret-key-for-computer-shopping-project-123456789";

    private final SecretKey key =
            Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(String username, String authority) {

        return Jwts.builder()
                .setSubject(username)
                .claim("authority", authority)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extractAuthority(String token) {

        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .get("authority", String.class);
    }

    public boolean isTokenValid(String token) {

        try {

            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}