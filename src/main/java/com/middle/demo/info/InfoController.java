package com.middle.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/request")
@RestController
public class InfoController {
    @Autowired
    private InfoService info_service;

    @GetMapping(value ="/{domain}")
    public Info getInfo(@PathVariable String domain) {
        return info_service.findInfo(domain);
    }
}
