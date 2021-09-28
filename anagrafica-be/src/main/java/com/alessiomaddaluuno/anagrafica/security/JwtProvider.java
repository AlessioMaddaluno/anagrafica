package com.alessiomaddaluuno.anagrafica.security;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;


public class JwtProvider {



    public static String createJwt(String subject, Map<String,String> payloadClaims) {

        JWTCreator.Builder builder =  JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(DateUtils.addMonths(new Date(), 1));

        if (payloadClaims != null && !payloadClaims.isEmpty()) {

            for (Map.Entry<String,String> entry : payloadClaims.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().toString());
            }
        }
        return builder.sign(Algorithm.HMAC256(SecurityConfig.secret));
    }

    public static DecodedJWT verifyJwt(String jwt) {
        return JWT.require(Algorithm.HMAC256(SecurityConfig.secret)).build().verify(jwt);
    }

    private JwtProvider() {}
}