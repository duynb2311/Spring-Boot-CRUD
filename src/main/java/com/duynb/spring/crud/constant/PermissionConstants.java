package com.duynb.spring.crud.constant;

import org.springframework.http.HttpMethod;

import java.util.*;

public class PermissionConstants {

    public static final Map<String,Permission> PERMISSION_MAP = new HashMap<>();

    static {
        PERMISSION_MAP.put("PERMISSION_UPDATE_CAU_THU", new Permission("/api/v1/cau-thu", HttpMethod.PUT));
        PERMISSION_MAP.put("PERMISSION_GET_CAU_THU_BY_CLB", new Permission("/api/v1/cau-thu/search?**", HttpMethod.GET));
        PERMISSION_MAP.put("PERMISSION_GET_CAU_THU_BY_ID", new Permission("/api/v1/cau-thu/**", HttpMethod.GET));
    }
    public static final Map<String, List<String>> ROLE_PERMISSIONS = new HashMap<>();

    static {
        ROLE_PERMISSIONS.put("USER", Arrays.asList("PERMISSION_GET_CAU_THU_BY_CLB", "PERMISSION_GET_CAU_THU_BY_ID"));
        ROLE_PERMISSIONS.put("ADMIN", Arrays.asList("PERMISSION_UPDATE_CAU_THU"));
        // Add more roles and their permissions here
    }

    public static class Permission{
        private final String endPoint;
        private final HttpMethod httpMethod;

        public Permission(String endPoint, HttpMethod httpMethod) {
            this.endPoint = endPoint;
            this.httpMethod = httpMethod;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public HttpMethod getHttpMethod() {
            return httpMethod;
        }
    }
}
