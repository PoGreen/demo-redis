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

    private static final String KEY ="class";
    private static final String KEYS ="classé";
    @Override
    public ClassEntity save(ClassEntity classEntity) {

        try {
            redisTemplate.opsForHash().put(KEY,classEntity.getId(),classEntity);
            return classEntity;
        }catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<ClassEntity> findAll() {
        return redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public List<ClassEntity> saveAll(List<ClassEntity> classEntities) {
        try{
            redisTemplate.opsForList().rightPush(KEYS,classEntities);
            return classEntities;
        }catch (Exception e){
            return null;
        }

    }
}
