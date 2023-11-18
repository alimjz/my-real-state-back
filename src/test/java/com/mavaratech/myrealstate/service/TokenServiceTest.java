package com.mavaratech.myrealstate.service;

import com.mavaratech.myrealstate.config.RealEstateConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TokenServiceTest {

    public static final String TEST_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJtaW5pQXBwTmFtZSI6ImFwcDphZG1pbjphbWxhay1lLW1hbiIsInVzZXJuYW1lIjoiMTExMTExMTExMSIsInN1YiI6Im1pbmlBcHAiLCJpYXQiOjE3MDAwNzk5MDYsImV4cCI6MTcwMDk0MzkwNn0.BDlNWcNwXio5xMGCLW98yji7hhFPurx0OuVfYwA-ndrnGdn3_UJfNdwqRBR7g7VIen4z6HZXhBA5t6Awm8WkWg";


    @Test
    void testJwtClaims() {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(RealEstateConstants.SECRET_KEY)
                .build().parseClaimsJws(TEST_TOKEN);
        String username = claimsJws.getBody().get("username", String.class);
        System.out.println(username);
        Assertions.assertEquals("1111111111",username);
    }
}