package com.example.springbootrest.service;

import com.example.springbootrest.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo getById(Integer id);

    void save(Todo todo);
    void deleteById(Integer id);

    List<Todo> getAllByDescr(String descr);
}
