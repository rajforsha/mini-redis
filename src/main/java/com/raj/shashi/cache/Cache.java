package com.raj.shashi.cache;

import com.raj.shashi.exception.KeyNotFoundException;

public  abstract class Cache<K,V> {

    private CacheType cacheType;
    public Cache(CacheType cacheType){
        this.cacheType = cacheType;
    }

    public abstract V get(K key);
    public abstract void put(K key, V value);
    public abstract void incrBy1(K key) throws KeyNotFoundException;
 }
