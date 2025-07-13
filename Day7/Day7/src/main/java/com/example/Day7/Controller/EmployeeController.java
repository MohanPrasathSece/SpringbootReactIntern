package com.example.Day7.Controller;

import com.example.Day7.Models.RegisterDetails;
import com.example.Day7.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") // Optional: helps organize routes
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route() {
        return "Welcome to SpringBoot Security";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<RegisterDetails> getAllEmployees() {
        return employeeService.getMethod();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{empId}")
    public RegisterDetails getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    // Uncomment and implement if needed
    /*
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/job/{job}")
    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job) {
        return employeeService.getEmployeeByJob(job);
    }
    */

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String addEmployee(@RequestBody RegisterDetails employee) {
        return employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable int empId, @RequestBody RegisterDetails updatedEmployee) {
        return employeeService.updateEmployee(empId, updatedEmployee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{empID}")
    public String deleteEmployee(@PathVariable int empID) {
        return employeeService.deleteEmployeeById(empID);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role/{roleName}")
    public List<RegisterDetails> getEmployeesByRole(@PathVariable String roleName) {
        return employeeService.getEmployeesByRole(roleName);
    }
}
