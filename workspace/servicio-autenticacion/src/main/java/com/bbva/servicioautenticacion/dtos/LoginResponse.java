package com.bbva.servicioautenticacion.dtos;


public class LoginResponse {
 private String token;
 private String tokenType = "Bearer";

 public LoginResponse(String token) {
     this.token = token;
 }

 // Getters y setters
 public String getToken() { return token; }
 public void setToken(String token) { this.token = token; }

 public String getTokenType() { return tokenType; }
}
