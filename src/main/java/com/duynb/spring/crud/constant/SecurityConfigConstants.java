package com.duynb.spring.crud.constant;

import org.springframework.http.HttpMethod;

/**
 * Lớp constant chứa danh sách các permission cho các role
 */
public class SecurityConfigConstants {

    public static final EndpointPermission[] ENDPOINT_PERMISSIONS = {
            new EndpointPermission("/auth/**", HttpMethod.POST, null),
            new EndpointPermission("/api/v1/cau-thu/**", HttpMethod.GET, "USER"),
            new EndpointPermission("/api/v1/cau-thu/**", HttpMethod.POST, "ADMIN"),
            new EndpointPermission("/api/v1/cau-thu/**", HttpMethod.PUT, "ADMIN")
    };

    public static class EndpointPermission {
        private final String endpoint;
        private final HttpMethod method;
        private final String role;

        public EndpointPermission(String endpoint, HttpMethod method, String role) {
            this.endpoint = endpoint;
            this.method = method;
            this.role = role;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public HttpMethod getMethod() {
            return method;
        }

        public String getRole() {
            return role;
        }
    }
}