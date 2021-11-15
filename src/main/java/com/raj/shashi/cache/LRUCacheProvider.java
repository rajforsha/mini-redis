package com.raj.shashi.cache;

import com.raj.shashi.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCacheProvider{

    private LRUCache instance;

    public LRUCache getInstance(CacheType cacheType, int size){

        synchronized (LRUCache.class){

            if(Objects.isNull(this.instance)){
                synchronized (LRUCache.class){

                    if(Objects.isNull(this.instance)){
                        this.instance = new LRUCache<String, String>(cacheType, size);
                    }
                }
            }
        }

        return this.instance;
    }


    static class LRUCache<K, V> extends Cache<K, V> {
        private int size;
        private LRUCache(CacheType cacheType, int size){
            super(cacheType);
            this.size = size;
        }


        private Map<K, V> map= new HashMap<>(this.size);


        public  V get(K key){
            return map.get(key);
        }

        public  void put(K key, V value){

            this.map.put(key, value);
        }

        public  void incrBy1(K key) throws KeyNotFoundException {
            synchronized (key){
                V value = this.map.get(key);
                System.out.println("current value is "+value);
                if(Objects.nonNull(value)){
                    int val = Integer.parseInt(String.valueOf(value));
                    val+=1;
                   // this.map.put(key, String.valueOf(val));
                    System.out.println("updated value is "+ (val));
                }
                else{
                    throw new KeyNotFoundException();
                }
            }
        }
    }

}
