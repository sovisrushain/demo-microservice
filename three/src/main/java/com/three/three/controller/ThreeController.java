package com.three.three.controller;

import com.three.three.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/three")
@RequiredArgsConstructor
public class ThreeController {

    private static final Integer INT_VALUE = 5;

    @GetMapping
    public ResponseEntity<ResponseDTO> getResource() {
        var res = ResponseDTO.builder()
                .statusCode("200")
                .response(INT_VALUE)
                .build();
        return ResponseEntity.ok(res);
    }
}
