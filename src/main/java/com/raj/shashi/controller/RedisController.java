package com.raj.shashi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/my-redis")
public class RedisController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody com.raj.shashi.dto.RequestBody requestBody){

    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id){

        return "";
    }

    @PutMapping("/increment/{id}")
    public void update(@PathVariable String id){

    }
}
