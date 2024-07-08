package com.edex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.demo.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
