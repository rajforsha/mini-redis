package com.raj.shashi.service;

import com.raj.shashi.exception.KeyNotFoundException;

public interface RedisService {

    String get(String id);

    void create (String id, String value);

    void update(String id) throws KeyNotFoundException;
}
