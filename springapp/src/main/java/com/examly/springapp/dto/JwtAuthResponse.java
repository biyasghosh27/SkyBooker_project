package com.examly.springapp.dto;

public class JwtAuthResponse {
    private String token;
    private int userId;
    private String userRole;
    private String username;
    private String email;
    
    public String getToken() {
        return token;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public JwtAuthResponse(String token, int userId, String userRole, String username, String email) {
        this.token = token;
        this.userId = userId;
        this.userRole = userRole;
        this.username = username;
        this.email = email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    
    public JwtAuthResponse() {
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}
