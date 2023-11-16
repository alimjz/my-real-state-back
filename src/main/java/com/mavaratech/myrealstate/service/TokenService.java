package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.RealEstateConstants;
import com.mavaratech.myrealstate.exceptions.RealStateException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public Jws<Claims> verifyToken(String token){
        try {
            token = removeBearer(token);
            return Jwts.parserBuilder().setSigningKey(RealEstateConstants.SECRET_KEY)
                    .build().parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new RealStateException("Token is Expired.",e);
        } catch (UnsupportedJwtException e) {
            throw new RealStateException("UnsupportedTokenFormat",e);
        } catch (MalformedJwtException e) {
            throw new RealStateException("MalformedJWTException",e);
        } catch (SignatureException e) {
            throw new RealStateException("Signiture Exception",e);
        } catch (IllegalArgumentException e) {
            throw new RealStateException("IllegalArgument Exception",e);
        }
    }

    private static String removeBearer(String token) {
        if (token.contains("Bearer ")){
            token = token.replace("Bearer ","");
        }
        return token;
    }

    public static String extractUsernameClaim(Jws<Claims> claimsJws) {
        return claimsJws.getBody().get("username", String.class);
    }


}
