package com.raj.shashi.service;

public interface RedisService {

    String get(String id);

    void create (String id, String value);

    void update(String id);
}
