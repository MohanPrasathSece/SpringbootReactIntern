package com.example.Day7.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId", nullable = false)
    private RegisterDetails employee;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private boolean completed;

    public Todo(RegisterDetails employee, String task) {
        this.employee = employee;
        this.task = task;
        this.completed = false;
    }
}
