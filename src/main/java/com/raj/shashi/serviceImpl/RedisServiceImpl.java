package com.raj.shashi.serviceImpl;

import com.raj.shashi.dao.RedisDao;
import com.raj.shashi.exception.KeyNotFoundException;
import com.raj.shashi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {


    RedisDao redisDao;

    @Autowired
    public RedisServiceImpl( RedisDao redisDao){
        this.redisDao = redisDao;
    }


    @Override
    public String get(String id){
        return redisDao.get(id);
    }

    @Override
    public void create (String id, String value){
        redisDao.create(id, value);
    }

    @Override
    public void update(String id) throws KeyNotFoundException {

        redisDao.update(id);

    }
}
