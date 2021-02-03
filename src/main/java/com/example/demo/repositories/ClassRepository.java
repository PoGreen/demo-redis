package com.example.demo.repositories;

import com.example.demo.models.entites.ClassEntity;

import java.util.List;

public interface ClassRepository {
    ClassEntity save(ClassEntity classEntity);
    List<ClassEntity> findAll();
    List<ClassEntity> saveAll(List<ClassEntity> classEntities);
}
