package com.two.two.controller;

import com.two.two.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class TwoController {

    private static final Integer INT_VALUE = 8;

    @GetMapping
    public ResponseEntity<ResponseDTO> getResource() {
        var res = ResponseDTO.builder()
                .statusCode("200")
                .response(INT_VALUE)
                .build();
        return ResponseEntity.ok(res);
    }
}
