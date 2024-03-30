package com.shoppingcart.rest.shoppingcartservice.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.security.Keys;


public class Constants {

    public static final String SELLER_ROLE = "seller";
    public static final String USER_ROLE = "user";
    public static final String Auth_HEADER = "Authorization";
    public static final String JWT_TOKEN_PREFIX = "Bearer";
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;
    public static final String JWT_SECRET = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";
    
}
