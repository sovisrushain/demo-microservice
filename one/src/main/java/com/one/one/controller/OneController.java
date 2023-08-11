package com.one.one.controller;

import com.one.one.dto.ResponseDTO;
import com.one.one.util.FeignProxyThree;
import com.one.one.util.FeignProxyTwo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
@RequiredArgsConstructor
@CircuitBreaker(name = "api-one-fallback-handler", fallbackMethod = "fallbackResponse")
public class OneController {

    private final FeignProxyTwo feignProxyTwo;
    private final FeignProxyThree feignProxyThree;

    @GetMapping
    public ResponseEntity<ResponseDTO> getResources() {
        Integer two = feignProxyTwo.retrieveFromTwo().getResponse();
        Integer three = feignProxyThree.retrieveFromThree().getResponse();

        Integer max = (two > three) ? two : three;

        ResponseDTO responseDTO = ResponseDTO.builder()
                .statusCode("200")
                .response(max)
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    public ResponseEntity<ResponseDTO> fallbackResponse(Exception exception) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .statusCode("503")
                .response(0)
                .build();

        return ResponseEntity.ok(responseDTO);
    }
}
