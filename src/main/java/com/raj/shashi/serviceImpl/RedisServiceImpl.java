package com.raj.shashi.serviceImpl;

import com.raj.shashi.dao.RedisDao;
import com.raj.shashi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisDao redisDao;

    // Lock lock = new ReentrantLock();

    @Override
    public String get(String id){
        return redisDao.get(id);

    }

    @Override
    public void create (String id, String value){
        synchronized (id){
            redisDao.create(id, value);
        }
    }

    @Override
    public void update(String id){

        synchronized (id){
            redisDao.update(id);
        }
    }
}
