package com.example.springbootrest.dao;


import com.example.springbootrest.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "select * from todos where todos.description = :descr", nativeQuery = true)
    List<Todo> findAllByDescr(@Param("descr") String description);

}
