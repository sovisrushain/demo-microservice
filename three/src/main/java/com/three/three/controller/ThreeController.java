package com.three.three.controller;

import com.three.three.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/three")
@RequiredArgsConstructor
public class ThreeController {

    @GetMapping
    public ResponseEntity<ResponseDTO> getResource() {
        var res = ResponseDTO.builder()
                .statusCode("200")
                .response(6)
                .build();
        return ResponseEntity.ok(res);
    }
}
