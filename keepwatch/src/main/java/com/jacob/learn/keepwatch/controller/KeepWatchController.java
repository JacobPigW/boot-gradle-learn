package com.jacob.learn.keepwatch.controller;

import com.jacob.learn.keepwatch.entity.KeepWatchArgs;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class KeepWatchController {

    @GetMapping("/uri1")
    public String getConf(@NotBlank(message = "mip cannot be empty")
            @RequestParam("mip") String mip) throws Exception {
        return "aaa";
    }

    /**
     * sys-agent 获取配置信息
     * @param args
     * @return
     */
    @PostMapping("/uri2")
    public String pullConf(@RequestBody @Validated KeepWatchArgs args) throws Exception {
        return "bbbbss";
    }
}
