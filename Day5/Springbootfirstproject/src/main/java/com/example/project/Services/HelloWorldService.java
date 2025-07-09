package com.example.project.Services;
import com.example.project.Models.Employee;
import com.example.project.Models.Student;
import com.example.project.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    StudentRepo studentRepo;

    public Student getStudentId(int StId)
    {
        return  studentRepo.findById(StId).orElseThrow(() -> new RuntimeException("Not found"));

    }


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public boolean addStudent(Student student) {
        studentRepo.save(student);
        return true;
    }

    public boolean UpdateStudent(int  id, Student student) {
        Student temp = studentRepo.findById(id).orElseThrow();
        temp.setName(student.getName());
        temp.setDept(student.getDept());
        studentRepo.save(temp);
        return true;
    }

    public boolean deleteStudent(Student student) {
        studentRepo.delete(student);
        return true;
    }


    public List<Student> getStudentsByName(String name) {
        return studentRepo.findByName(name);
    }
}
