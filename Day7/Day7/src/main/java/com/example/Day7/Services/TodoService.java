package com.example.Day7.Services;

import com.example.Day7.Models.Todo;
import java.util.List;

public interface TodoService {
    // Get all todos for an employee by empId
    List<Todo> getTodosForEmployee(int empId);

    // Add a new todo for an employee
    String addTodoForEmployee(int empId, Todo todo);

    // Update the completion status of a todo by todoId
    String updateTodoStatus(int todoId, boolean completed);
}
