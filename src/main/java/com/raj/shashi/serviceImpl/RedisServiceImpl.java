package com.raj.shashi.serviceImpl;

import com.raj.shashi.cache.Cache;
import com.raj.shashi.cache.CacheProvider;
import com.raj.shashi.cache.CacheType;
import com.raj.shashi.cache.LRUCacheProvider;
import com.raj.shashi.exception.KeyNotFoundException;
import com.raj.shashi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.LRUCache;


@Service
public class RedisServiceImpl implements RedisService {


    Cache cache;

    @Autowired
    public RedisServiceImpl(){

        this.cache = new CacheProvider().getCache(CacheType.LRU, 100);
    }


    @Override
    public String get(String id){
        return (String)this.cache.get(id);
    }

    @Override
    public void create (String id, String value){
        this.cache.put(id, value);
    }

    @Override
    public void update(String id) throws KeyNotFoundException {

        this.cache.incrBy1(id);

    }
}
