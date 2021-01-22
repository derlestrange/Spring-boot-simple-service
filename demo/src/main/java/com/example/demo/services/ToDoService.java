package com.example.demo.services;

import com.example.demo.model.ToDo;

import java.util.List;

public interface ToDoService {
    public List<ToDo> getAllToDo();
    public ToDo getToDoById(long id);
    public ToDo saveToDo(ToDo todo);
    public void removeToDo(ToDo todo);
}
