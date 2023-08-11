package com.two.two.controller;

import com.two.two.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class TwoController {

    @GetMapping
    public ResponseEntity<ResponseDTO> getResource() {
        var res = ResponseDTO.builder()
                .statusCode("200")
                .response(10)
                .build();
        return ResponseEntity.ok(res);
    }
}
