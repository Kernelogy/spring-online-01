package com.edex.demo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.model.Employee;
import com.edex.demo.model.Project;
import com.edex.demo.repo.EmployeeRepo;
import com.edex.demo.repo.ProjectRepo;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ProjectRepo projectRepo;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Employee employee){
        Set<Project> projects = new HashSet<Project>(0);
        for(Project e : employee.getProjects()){
            Project entity = projectRepo.save(e);
            projects.add(entity);
        }
        employee.setProjects(projects);
        Employee entity = employeeRepo.save(employee);
        return ResponseEntity.ok().body(entity);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable final int id) {
        Employee entity = employeeRepo.findById(id).get();
        if(entity != null){
            return ResponseEntity.ok().body(entity);
        }
        return ResponseEntity.ok().body("Employee Not Found");
    }
    
}
