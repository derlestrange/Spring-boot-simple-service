package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.services.ToDoServiceImplementation;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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
    public void testGetToDoById(){
        ToDo toDo = new ToDo(1,"Todo Sample 1",true);
        when(toDoRepository.findOne(1L)).thenReturn(toDo);
        ToDo result = toDoService.getToDoById(1);
        assertEquals(1, result.getId());
        assertEquals("Todo Sample 1", result.getText());
        assertEquals(true, result.isCompleted());
    }

    @Test
    public void saveToDo(){
        ToDo toDo = new ToDo(8,"Todo Sample 8",true);
        when(toDoRepository.save(toDo)).thenReturn(toDo);
        ToDo result = toDoService.saveToDo(toDo);
        assertEquals(8, result.getId());
        assertEquals("Todo Sample 8", result.getText());
        assertEquals(true, result.isCompleted());
    }

    @Test
    public void removeToDo(){
        ToDo toDo = new ToDo(8,"Todo Sample 8",true);
        toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
    }
}