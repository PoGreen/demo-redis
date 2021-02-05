package com.example.demo.controller;

import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseContent;
import com.example.demo.models.entites.ClassEntity;
import com.example.demo.models.in.ClassIn;
import com.example.demo.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ResponseContent<ClassEntity>> create(@RequestBody ClassIn classIn) {
        return classService.create(classIn);
    }
    @PutMapping
    public ResponseEntity<ResponseContent<ClassEntity>> update(@RequestParam(value = "id") int id,
                                                              @RequestBody ClassIn classIn) {
        return null;
    }
    @DeleteMapping
    public Response delete(@RequestParam(value = "id") int id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<ResponseContent<List<ClassEntity>>> findAll() {
        return classService.fingAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<ResponseContent<List<ClassEntity>>> createAll(@RequestBody List<ClassIn> classIns) {
        return classService.createAll(classIns);
    }
}
