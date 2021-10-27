package com.raj.shashi.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RedisDaoImpl implements RedisDao{

    private Map<String, String> map;

    private final ReentrantLock lock;

    public RedisDaoImpl(){

        map = new ConcurrentHashMap<>();
        lock = new ReentrantLock();
    }

    public String get(String id){
        return this.map.get(id);
    }

    public void create (String id, String value){
        synchronized (id){
            this.map.put(id, value);
        }
    }

    public void update(String id){
        System.out.println(Thread.currentThread().getName());
        synchronized (RedisDaoImpl.class){
            String value = this.map.get(id);
            System.out.println("current value is "+value);
            if(Objects.nonNull(value)){
                AtomicInteger val = new AtomicInteger(Integer.parseInt(value));
                this.map.put(id, String.valueOf(val.incrementAndGet()));
                System.out.println("updated value is "+ (val));
            }
        }
    }
}
