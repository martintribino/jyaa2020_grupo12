package com.security;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JWToken {

    public static final String TOKENKEY = "JyAA.tribm.hd17**";
    public final static String AUTHORIZATION_HEADER = "Authorization";
    public final static String AUTHORIZATION_PREFIX = "Bearer ";
	private static final int EXPIRATION_LIMIT = 30;
	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	final static Key secret = MacProvider.generateKey(signatureAlgorithm);
	final static byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWToken.TOKENKEY);
    final static Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	public JWToken() {
	}

	public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(JWToken.AUTHORIZATION_HEADER);
        if(JWToken.hasText(token)) {
        	token = token.replace(JWToken.AUTHORIZATION_PREFIX, "");
        }
        return (JWToken.hasText(token)) ? token : null;
    }

	public static String getToken(String rawToken) {
        String token = rawToken;
        if(JWToken.hasText(rawToken)) {
        	token = rawToken.replace(JWToken.AUTHORIZATION_PREFIX, "");
        }
        return (JWToken.hasText(token)) ? token : null;
    }

	public static Boolean checkToken(ServletRequest request) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = JWToken.getToken(httpServletRequest);
        return JWToken.isValidToken(token);
	}
	
	public static String generar(String nombreUsuario) {
	    Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
	    Instant expiration = issuedAt.plus(JWToken.EXPIRATION_LIMIT, ChronoUnit.MINUTES);
        JwtBuilder jwtBuilder = Jwts.builder()
		        .setSubject(nombreUsuario)
		        .setIssuedAt(Date.from(issuedAt))
		        .setExpiration(Date.from(expiration))
		        .signWith(signatureAlgorithm, secret);
		String token = jwtBuilder.compact();

		return token;
    }
	
	public static String generar(Long id) {
	    Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
	    Instant expiration = issuedAt.plus(JWToken.EXPIRATION_LIMIT, ChronoUnit.MINUTES);
        JwtBuilder jwtBuilder = Jwts.builder()
		        .setSubject(id.toString())
		        .setIssuedAt(Date.from(issuedAt))
		        .setExpiration(Date.from(expiration))
		        .signWith(signatureAlgorithm, secret);
		String token = jwtBuilder.compact();

		return token;
    }

    public static String parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            return body.getSubject();
        } catch (JwtException e) {
            return null;
        }
    }

	public static Claims validateToken(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(secret)
	                .parseClaimsJws(token)
	                .getBody();
	        return claims;
	}

	private static Boolean isValidToken(String token) {
        return (JWToken.hasText(token));
    }

	public static boolean hasText(CharSequence str) {
		return (str != null && str.length() > 0 && containsText(str));
	}
	
	public static boolean hasText(String str) {
		return (str != null && !str.isEmpty() && containsText(str));
	}

	private static boolean containsText(CharSequence str) {
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

}

