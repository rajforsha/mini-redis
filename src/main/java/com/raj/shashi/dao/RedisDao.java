package com.raj.shashi.dao;

import com.raj.shashi.exception.KeyNotFoundException;

public interface RedisDao {

    String get(String id);

    void create (String id, String value);

    void update(String id) throws KeyNotFoundException;
}
