package com.example.demo.services.mappers;

import com.example.demo.models.entites.ClassEntity;
import com.example.demo.models.in.ClassIn;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClassMapper {

    public static final Gson gson = new Gson();

    public ClassEntity mapToEntity(ClassIn classIn){
        ClassEntity entity = new ClassEntity();
        UUID uuid = UUID.randomUUID();
        entity.setId(uuid.toString());
        entity.setName(classIn.getName());
        return entity;
    }

    public List<ClassEntity> mapToEntitys(List<ClassIn> classIns){

        return classIns.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public String mapToJsonString(ClassEntity classEntity){
     return gson.toJson(classEntity);
    }
    public ClassEntity mapToEntity(String strJsonClass){
        return gson.fromJson(strJsonClass,ClassEntity.class);
    }
}
