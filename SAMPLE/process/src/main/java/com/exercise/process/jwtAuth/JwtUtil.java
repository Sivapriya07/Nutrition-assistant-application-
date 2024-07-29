package com.exercise.process.jwtAuth;

import com.exercise.process.Entity.User;
import com.exercise.process.dto.loginDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    public static final String secret = "5B4AFC43C03AFC83CEA7554AF7D430F74CC87D7DFB3AEE4CF1C7F78DE147874BF82BF5C628434DFECCA445D3433AD10CE3313975F098F444C9B8B377DBC58614";

//    public String GenerateJwt(User user) {
//        //claims
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, user.getName());
//    }

    //token generation using Jwts->builder()
//    private String createToken(Map<String, Object> claims, String Subject) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(Subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }

    public HashMap<String,String> generateToken(loginDTO logindto)
    {
        Map<String,String> map=new HashMap<String,String>();

        String val= Jwts.builder()
                .setClaims(map)
                .setSubject(logindto.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        HashMap<String,String> response=new HashMap<String,String>();
        response.put("token",val);
        return response;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, User user) {
        final String username = extractUsername(token);
        return (username.equals(user.getName()) && !isTokenExpired(token));
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }
    public List<String> extractroles(String token){
        final Claims claims=extractAllClaims(token);
        return claims.get("roles",List.class);
    }
}





