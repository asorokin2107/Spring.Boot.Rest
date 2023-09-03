package com.example.springbootrest.service;

import com.example.springbootrest.dao.TodoRepository;
import com.example.springbootrest.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jdk.internal.vm.compiler.word.LocationIdentity.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodoServiceImplTest {

    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;


    @Test
    @Transactional
    @Rollback
    void getAll() {
        Todo todo = new Todo();
        todo.setTitle("Buy Milk");
        todo.setDescription("Two milk");
        todo.setPriority("Important");
        todoRepository.save(todo);
        Todo todo2 = new Todo();
        todo2.setTitle("Buy Chocolate");
        todo2.setDescription("Two");
        todo2.setPriority("Med");
        todoRepository.save(todo2);

        List<Todo> all = todoService.getAll();

        assertNotNull(all);
        assertEquals(todoRepository.count(), all.size());
    }
    @Test
    @Rollback
    void getById() {
        Todo todo = new Todo();
        todo.setDescription("test");
        Todo save = todoRepository.save(todo);

        Todo finded = todoService.getById(save.getId());

        assertNotNull(finded);
        assertEquals(save.getId(), finded.getId());
        assertEquals(save.getDescription(), finded.getDescription());

    }

    @Test
    @Transactional
    void deleteById() {
        Todo todo = new Todo();
        Todo save = todoRepository.save(todo);
        int id = save.getId();

        assertNotNull(todoService.getById(id));

        todoService.deleteById(id);

        assertNull(todoRepository.findById(id).orElse(null));

    }
    @Test
    @Transactional
    void getAllByDescr() {
        Todo todo = new Todo();
        todo.setDescription("test");
        Todo todo1 = new Todo();
        todo1.setDescription("test");
        todoRepository.save(todo);
        todoRepository.save(todo1);

        List<Todo> todos = todoService.getAllByDescr("test");

        assertNotNull(todos);
        assertTrue(todos.size() >= 2);
    }





}


