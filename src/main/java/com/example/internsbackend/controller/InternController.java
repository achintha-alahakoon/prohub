package com.example.internsbackend.controller;

import com.example.internsbackend.model.interns;
import com.example.internsbackend.service.internService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private internService internService;

    @GetMapping
    public List<interns> getAllInterns() {
        return internService.getAllInterns();
    }

    @PostMapping
    public interns addIntern(@RequestBody interns intern) {
        return internService.addIntern(intern);
    }

    @PutMapping("/{id}")
    public interns updateIntern(@PathVariable Integer id, @RequestBody interns intern) {
        return internService.updateIntern(id, intern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteIntern(@PathVariable Integer id) {
        internService.softDeleteIntern(id);
        return ResponseEntity.ok("Intern status updated to false (soft deleted)");
    }
}