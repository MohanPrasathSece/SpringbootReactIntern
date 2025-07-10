package com.example.service;

import com.example.model.Employee;
import com.example.model.Todo;
import com.example.repository.EmployeeRepository;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private TodoRepository todoRepository;
    
    // 1. Update query by id
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            
            if (updatedEmployee.getName() != null) {
                employee.setName(updatedEmployee.getName());
            }
            
            if (updatedEmployee.getEmail() != null) {
                employee.setEmail(updatedEmployee.getEmail());
            }
            
            if (updatedEmployee.getRole() != null) {
                employee.setRole(updatedEmployee.getRole());
            }
            
            return employeeRepository.save(employee);
        }
        return null;
    }
    
    // 2. Find by roles specified
    public List<Employee> findByRole(String role) {
        return employeeRepository.findByRoleIgnoreCase(role);
    }
    
    // 3. Todo of an employee
    public List<Todo> getTodosByEmployeeId(Long employeeId) {
        return todoRepository.findByEmployeeId(employeeId);
    }
    
    // Helper methods
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}