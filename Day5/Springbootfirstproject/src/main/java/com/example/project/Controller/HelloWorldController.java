package com.example.project.Controller;
import com.example.project.Models.Employee;
import com.example.project.Models.Student;
import com.example.project.Services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/std")
public class HelloWorldController {

    @Autowired
    private HelloWorldService sws;

    @GetMapping
    public List<Student> getAllStudents()
    {
        return sws.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentId(@PathVariable int id) {
        System.out.println(id);
        return sws.getStudentId(id);
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        if(sws.addStudent(student))
        {
            return "Success";
        }
        return "Not Success";
    }

    @PutMapping("/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable int id) {
            if(sws.UpdateStudent(id,student))
            {
                return "Success";
            }
            return "Not Success";
    }
    @DeleteMapping
    public String deleteStudent(@RequestBody Student student) {
        if(sws.deleteStudent(student))
        {
            return "Success";
        }
        return "Not Success";

    }

    @GetMapping("/name")
    public List<Student> getStudentsByname(@RequestParam String name){
        return sws.getStudentsByName(name);
    }

}
