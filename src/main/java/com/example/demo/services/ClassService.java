package com.example.demo.services;

import com.example.demo.exceptions.ResponseContent;
import com.example.demo.models.entites.ClassEntity;
import com.example.demo.models.in.ClassIn;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassService {

    ResponseEntity<ResponseContent<ClassEntity>> create(ClassIn classIn);

    ResponseEntity<ResponseContent<ClassEntity>> update(ClassIn classIn);

    ResponseEntity<ResponseContent<String>> delete(int id);

    ResponseEntity<ResponseContent<List<ClassEntity>>> fingAll();

    ResponseEntity<ResponseContent<List<ClassEntity>>> createAll(List<ClassIn> classIns);
}
