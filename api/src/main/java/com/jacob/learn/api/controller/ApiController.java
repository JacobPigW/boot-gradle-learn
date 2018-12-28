package com.jacob.learn.api.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@Validated
@RestController
public class ApiController {


    @GetMapping("/uri/1")
    public String getSyslogRules() throws Exception {
        return "api 1";
    }

    @GetMapping("/uri/2/{id}")
    public String get(@Min(value = 1, message = "id must be >= 1")
                              @PathVariable("id") Integer id) throws Exception {
        return "api 2";
    }
}
