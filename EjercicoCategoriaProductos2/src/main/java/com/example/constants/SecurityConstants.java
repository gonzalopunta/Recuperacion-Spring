package com.example.constants;

public final class SecurityConstants {
	//URL para la autenticacion inicial con ("username": "user" y "password":"password2")
    public static final String AUTH_LOGIN_URL = "/login";
    public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";
    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
