package com.example.repository;

import com.example.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    // 3. Todo of an employee
    List<Todo> findByEmployeeId(Long employeeId);
}