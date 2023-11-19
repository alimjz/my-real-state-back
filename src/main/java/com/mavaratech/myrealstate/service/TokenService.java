package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.RealEstateConstants;
import com.mavaratech.myrealstate.exceptions.InvalidTokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static String removeBearer(String token) {
        if (token.contains("Bearer ")) {
            token = token.replace("Bearer ", "");
        }
        return token;
    }

    public static String extractUsernameClaim(Jws<Claims> claimsJws) {
        return claimsJws.getBody().get("username", String.class);
    }

    public Jws<Claims> verifyToken(String token) {
        try {
            token = removeBearer(token);
            return Jwts.parserBuilder().setSigningKey(RealEstateConstants.SECRET_KEY)
                    .build().parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new InvalidTokenException("Token is Expired.", e);
        } catch (InvalidTokenException e) {
            throw new InvalidTokenException("UnsupportedTokenFormat", e);
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException("MalformedJWTException", e);
        } catch (SignatureException e) {
            throw new InvalidTokenException("Signiture Exception", e);
        } catch (IllegalArgumentException e) {
            throw new InvalidTokenException("IllegalArgument Exception", e);
        }
    }


}
