package com.raj.shashi.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class RedisDaoImpl implements RedisDao{

    private Map<String, String> map= new HashMap<>();

    public String get(String id){
        return map.get(id);
    }

    public void create (String id, String value){
        map.put(id, value);
    }

    public void update(String id){
        String value = map.get(id);
        if(Objects.nonNull(value)){
            int val = Integer.parseInt(value);
            val+=1;
            map.put(id, String.valueOf(val));
        }
    }
}
