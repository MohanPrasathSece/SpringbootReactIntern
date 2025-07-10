package com.example.controller;

import com.example.model.Employee;
import com.example.model.Todo;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }
    
    // 1. Update query by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }
    
    // 2. Find by roles specified
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Employee>> findByRole(@PathVariable String role) {
        List<Employee> employees = employeeService.findByRole(role);
        return ResponseEntity.ok(employees);
    }
    
    // 3. Todo of an employee
    @GetMapping("/{id}/todos")
    public ResponseEntity<List<Todo>> getEmployeeTodos(@PathVariable Long id) {
        if (employeeService.getEmployeeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        List<Todo> todos = employeeService.getTodosByEmployeeId(id);
        return ResponseEntity.ok(todos);
    }
}