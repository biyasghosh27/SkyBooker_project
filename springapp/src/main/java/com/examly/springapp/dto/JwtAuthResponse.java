package com.examly.springapp.dto;

public class JwtAuthResponse {
    private String token;
    private int userId;
    private String userRole;
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public JwtAuthResponse(String token, int userId, String userRole) {
        this.token = token;
        this.userId = userId;
        this.userRole = userRole;
    }
    public JwtAuthResponse() {
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}
