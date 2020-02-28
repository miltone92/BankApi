package com.bbg.bankapi.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JWTConfig {

    // We need a signing key, so we'll create one just for this example. Usually
    // the key would be read from your application configuration instead.
    public Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String generateKey(String subject) {
        return Jwts.builder().setSubject(subject).signWith(this.key).compact();
    }

    public String validateKey(String jws) {

        try {

            Jwts.parser().setSigningKey(this.key).parseClaimsJws(jws);
            return "authorized";

        } catch (Exception e) {
            return e.toString();
        }

    }

}