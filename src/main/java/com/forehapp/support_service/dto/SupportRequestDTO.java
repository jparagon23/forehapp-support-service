package com.forehapp.support_service.dto;


public class SupportRequestDTO {
    private String message;
    private Long userId;
    private String name;
    private String email;

    public String getMessage() {
        return message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
