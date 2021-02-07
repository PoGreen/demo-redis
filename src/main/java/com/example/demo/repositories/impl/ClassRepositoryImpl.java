package com.example.demo.repositories.impl;

import com.example.demo.models.entites.ClassEntity;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.mappers.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Repository
public class ClassRepositoryImpl implements ClassRepository {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ClassMapper classMapper;

    private static final String KEY = "classes:class:";

    @Override
    public ClassEntity save(ClassEntity classEntity) {
        try {
            String strJsonClass = classMapper.mapToJsonString(classEntity);
            redisTemplate.opsForValue().set(KEY + classEntity.getId(), strJsonClass);
            return classEntity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ClassEntity> findAll() {
        Set<byte[]> keys = redisTemplate.getConnectionFactory().getConnection().keys("*".getBytes());

        if (keys != null) {
            return keys.stream().map(String::new).filter(temp -> temp.contains(KEY))
                    .map(temp -> temp.substring(temp.lastIndexOf(":") + 1))
                    .map(this::findById)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public ClassEntity findById(String id) {
        try {
            String strJsonCLass = redisTemplate.opsForValue().get(KEY + id).toString();

            return classMapper.mapToEntity(strJsonCLass);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ClassEntity> saveAll(List<ClassEntity> classEntities) {
        try {
            classEntities.forEach(this::save);
            return classEntities;
        } catch (Exception e) {
            return null;
        }

    }
}
