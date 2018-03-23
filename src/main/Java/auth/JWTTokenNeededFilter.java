package auth;


import com.auth0.jwk.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


import java.security.interfaces.RSAPublicKey;
import javax.ws.rs.ext.Provider;

@Provider
public class JWTTokenNeededFilter implements ContainerRequestFilter {
    String AUTH_URL = System.getenv("AUTH_URL");
    @Override
    public ContainerRequest filter(ContainerRequest requestContext) {
//
//        // Get the HTTP Authorization header from the request
//        String authorizationHeader = requestContext.getHeaderValue(HttpHeaders.AUTHORIZATION);
//
//        if (authorizationHeader==null||authorizationHeader.isEmpty()) {
//            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
//        }
//        // Extract the token from the HTTP Authorization header
//        String token = authorizationHeader.substring("Bearer".length()).trim();
//        String kid;
//        try {
//            kid = JWT.decode(token).getKeyId();
//        } catch (JWTDecodeException exception){
//            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
//        }
//
//        RSAPublicKey publicKey = getPublicKeyById(kid);
//        String userId;
//        try {
//            Algorithm algorithm = Algorithm.RSA256(publicKey);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withIssuer(AUTH_URL)
//                    .build(); //Reusable verifier instance
//            DecodedJWT jwt = verifier.verify(token);
//            userId = jwt.getSubject();
//        } catch (JWTVerificationException exception) {
//            throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN).build());
//        }
       return requestContext;
    }

    public RSAPublicKey getPublicKeyById(String keyId) {
        JwkProvider provider = new UrlJwkProvider(AUTH_URL);
        Jwk jwk = null;
        try {
            jwk = provider.get(keyId);
        } catch (JwkException e) {
            e.printStackTrace();
        }
        try {
            return (RSAPublicKey)jwk.getPublicKey();
        } catch (InvalidPublicKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
