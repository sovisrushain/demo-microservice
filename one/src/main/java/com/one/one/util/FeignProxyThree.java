package com.one.one.util;

import com.one.one.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "serviceThree")
public interface FeignProxyThree {

    @GetMapping("/three")
    ResponseDTO retrieveFromThree();

}
