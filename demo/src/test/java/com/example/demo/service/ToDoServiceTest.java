package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.services.ToDoServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceImplementation toDoService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllToDo(){
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1,"Todo Sample 1",true));
        toDoList.add(new ToDo(2,"Todo Sample 2",true));
        toDoList.add(new ToDo(3,"Todo Sample 3",false));
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> result = toDoService.getAllToDo();
        assertEquals(3, result.size());
    }

    @Test
    public void saveToDo(){
        ToDo toDo = new ToDo(8,"Todo Sample 8",true);
        when(toDoRepository.save(toDo)).thenReturn(toDo);
        ToDo result = toDoService.saveToDo(toDo);
        assertEquals(8, result.getId());
        assertEquals("Todo Sample 8", result.getText());
        assertTrue(result.isCompleted());
    }

    @Test
    public void removeToDo(){
        ToDo toDo = new ToDo(8,"Todo Sample 8",true);
        toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
    }
}