package com.example.Day7.Services;

import com.example.Day7.Models.RegisterDetails;
import com.example.Day7.Models.Todo;
import com.example.Day7.Repository.TodoRepository;
import com.example.Day7.Repository.RegisterDetailsRepository;  // Make sure this is imported
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;  // Autowire the RegisterDetailsRepository

    @Override
    public List<Todo> getTodosForEmployee(int empId) {
        // Return all todos for the given employee
        return todoRepository.findByEmployee_EmpId(empId);
    }

    @Override
    public String addTodoForEmployee(int empId, Todo todo) {
        // Fetch the employee by empId from the database
        RegisterDetails employee = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Set the employee to the todo
        todo.setEmployee(employee);

        // Save the new todo in the database
        todoRepository.save(todo);
        return "Todo Added Successfully";
    }

    @Override
    public String updateTodoStatus(int todoId, boolean completed) {
        // Find the todo by ID
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException("Todo not found"));

        // Update the completed status of the todo
        todo.setCompleted(completed);

        // Save the updated todo back to the database
        todoRepository.save(todo);
        return "Todo Status Updated Successfully";
    }
}
