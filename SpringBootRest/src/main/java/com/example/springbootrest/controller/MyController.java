package com.example.springbootrest.controller;

import com.example.springbootrest.entity.Todo;
import com.example.springbootrest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/todos")
    public List<Todo> showAllTodo(){
        return todoService.getAll();
    }

    @GetMapping("/todos/{id}")
    public Todo getById(@PathVariable Integer id) {
        return todoService.getById(id);

    }

    @GetMapping("/todos/desc/{description}")
    public List<Todo> getTodoByDescr(@PathVariable String description) {
        List<Todo> todos = todoService.getAllByDescr(description);
        return todos;
    }
}
