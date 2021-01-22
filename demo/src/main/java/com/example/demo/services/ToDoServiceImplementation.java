package com.example.demo.services;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("toDoService")
public class ToDoServiceImplementation implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(long id) {
        return toDoRepository.getOne(id);
    }

    @Override
    public ToDo saveToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public void removeToDo(ToDo todo) {
        toDoRepository.delete(todo);
    }
}
