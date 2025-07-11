package com.forehapp.support_service.controller;

import com.forehapp.support_service.dto.SupportRequestDTO;
import com.forehapp.support_service.services.SupportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/support")
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }


    @PostMapping("/report")
    public ResponseEntity<?> reportIssue(@RequestBody SupportRequestDTO request) {
        supportService.handleSupportRequest(request);
        return ResponseEntity.ok().build();
    }
}
