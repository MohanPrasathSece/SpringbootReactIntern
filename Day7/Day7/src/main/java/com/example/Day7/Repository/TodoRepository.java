package com.example.Day7.Repository;


import com.example.Day7.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByEmployee_EmpId(int empId);
}
