package com.example.springbootrest.service;

import com.example.springbootrest.dao.TodoRepository;
import com.example.springbootrest.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<Todo> getAll() {
        log.info("start getAll method");
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(Integer id) {
        log.info("start finding todo with id {}", id);
        Todo todo = todoRepository.findById(id).orElse(null);
        if(todo == null) {
            log.warn("todo with id {} is not found", id);

         } else  {
            log.info("todo with id {} found {}", id, todo);
        }
        return todo;
    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);

    }

    @Override
    public void deleteById(Integer id) {
        todoRepository.deleteById(id);

    }

    @Override
    public List<Todo> getAllByDescr(String description) {
        return todoRepository.findAllByDescr(description);
    }
}
