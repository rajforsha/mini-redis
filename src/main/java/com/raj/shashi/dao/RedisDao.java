package com.raj.shashi.dao;

public interface RedisDao {

    String get(String id);

    void create (String id, String value);

    void update(String id);
}
