package com.duynb.spring.crud.constant;

public class ConfigConstants {
    public static final String AUTHORIZATION_TYPE = "JWT";
    public static final String APIKEY_NAME = "Authorization";
    public static final String APIKEY_PASS_AS = "header";
    public static final String AUTHORIZATION_SCOPE = "global";
    public static final String AUTHORIZATION_SCOPE_DESCRIPTION = "accessEverything";
    public static final Integer AUTHORIZATION_SCOPE_SIZE = 1;
    public static final String SWAGGER_BASE_PACKAGE = "com.duynb.spring.crud.controller";
    public static final String APIINFO_TITLE = "My REST API";
    public static final String APIINFO_DESCRIPTION = "Some custom description of API.";
    public static final String APIINFO_VERSION = "1.0";
    public static final String APIINFO_TERM_OF_SERVICE = "Terms of service";
    public static final String APIINFO_CONTACT_NAME= "Nguyen Ba Duy";
    public static final String APIINFO_CONTACT_URL = "www.facebook.com";
    public static final String APIINFO_CONTACT_EMAIL= "nguyenbaduy23112001@gmail.com";
    public static final String APIINFO_LICENSE = "License of API";
    public static final String APIINFO_LICENSE_URL = "API license URL";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_PUT = "PUT";
    public static final String HTTP_METHOD_DELETE = "DELETE";
    public static final Integer CORS_MAPPING_MAX_AGE = 3600;

    public static final String INVALID_TOKEN_MESSAGE ="Invalid JWT token";
    public static final String EXPIRED_TOKEN_MESSAGE ="Expired JWT token";
    public static final String UNSUPPORTED_TOKEN_MESSAGE ="Unsupported JWT token";
    public static final String EMPTY_TOKEN_MESSAGE ="JWT claims string is empty.";
    public static final String INVALID_SIGNATURE_MESSAGE ="JWT signature not valid.";
    public static final String USER_NOT_FOUND_MESSAGE ="User not found.";

}
