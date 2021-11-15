package com.raj.shashi.cache;

public class CacheProvider {


    public  Cache getCache(CacheType cacheType, int size){

        if(cacheType.equals(CacheType.LRU)){
            return new LRUCacheProvider().getInstance(CacheType.LRU, size);
        }

        return null;

    }
}
