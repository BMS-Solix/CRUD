package com.solix.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solix.demo.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
