package com.example.Day7.Controller;
import com.example.Day7.Models.Todo;
import com.example.Day7.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/{empId}")
    public List<Todo> getTodosForEmployee(@PathVariable int empId) {
        return todoService.getTodosForEmployee(empId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("/employee/{empId}")
    public String addTodoForEmployee(@PathVariable int empId, @RequestBody Todo todo) {
        return todoService.addTodoForEmployee(empId, todo);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/{todoId}")
    public String updateTodoStatus(@PathVariable int todoId, @RequestParam boolean completed) {
        return todoService.updateTodoStatus(todoId, completed);
    }
}
