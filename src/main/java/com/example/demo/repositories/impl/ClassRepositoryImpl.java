package com.example.demo.repositories.impl;

import com.example.demo.models.entites.ClassEntity;
import com.example.demo.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClassRepositoryImpl implements ClassRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY =":class";
    @Override
    public ClassEntity save(ClassEntity classEntity) {

        try {
            redisTemplate.opsForList().rightPush(KEY,classEntity);
            return classEntity;
        }catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<ClassEntity> findAll() {
        long size = redisTemplate.opsForList().size(KEY);
        return redisTemplate.opsForList().range(KEY,0,size);
    }

    @Override
    public List<ClassEntity> saveAll(List<ClassEntity> classEntities) {
        try{
            redisTemplate.opsForList().rightPushAll(KEY,classEntities);
            return classEntities;
        }catch (Exception e){
            return null;
        }

    }
}
