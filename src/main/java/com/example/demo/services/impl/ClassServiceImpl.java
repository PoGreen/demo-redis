package com.example.demo.services.impl;

import com.example.demo.exceptions.HttpMessage;
import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseContent;
import com.example.demo.models.entites.ClassEntity;
import com.example.demo.models.in.ClassIn;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.ClassService;
import com.example.demo.services.mappers.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClassServiceImpl implements ClassService {


    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassMapper classMapper;


    @Override
    public ResponseEntity<ResponseContent<ClassEntity>> create(ClassIn classIn) {

        ClassEntity entity = classMapper.mapToEntity(classIn);

        entity = classRepository.save(entity);
        if(Objects.isNull(entity)){
            return Response.badRequest(HttpMessage.NOT_SUCCESS);
        }
        return Response.ok(entity);
    }

    @Override
    public ResponseEntity<ResponseContent<ClassEntity>> update(ClassIn classIn) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseContent<String>> delete(int id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseContent<List<ClassEntity>>> fingAll() {
        return Response.ok(classRepository.findAll());
    }

    @Override
    public ResponseEntity<ResponseContent<List<ClassEntity>>> createAll(List<ClassIn> classIns) {
        List<ClassEntity> classEntities = classMapper.mapToEntitys(classIns);
        classEntities = classRepository.saveAll(classEntities);

        if(Objects.isNull(classEntities)){
            return Response.badRequest(HttpMessage.NOT_SUCCESS);
        }
        return Response.ok(classEntities);
    }
}
