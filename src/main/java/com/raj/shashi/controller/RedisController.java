package com.raj.shashi.controller;

import com.raj.shashi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/my-redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody com.raj.shashi.dto.RequestBody requestBody){
        redisService.create(requestBody.getKey(), requestBody.getValue());
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id){

        return redisService.get(id);
    }

    @PutMapping("/increment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable String id){
        redisService.update(id);
    }
}
