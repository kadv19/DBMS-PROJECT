package com.carrental.controller;

import com.carrental.model.SOSRequest;
import com.carrental.service.SOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sos")
public class SOSController {
    @Autowired
    private SOSService sosService;

    @PostMapping
    public ResponseEntity<Object> createSOSRequest(@RequestBody SOSRequest sosRequest) {
        return ResponseEntity.ok(sosService.createSOSRequest(sosRequest));
    }
}