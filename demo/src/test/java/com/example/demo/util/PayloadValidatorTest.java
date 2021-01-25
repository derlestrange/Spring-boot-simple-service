package com.example.demo.util;

import com.example.demo.model.ToDo;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PayloadValidatorTest {

    @Test
    public void validatePayLoad() {
        ToDo toDo = new ToDo(1, "Sample ToDo 1", true);
        assertFalse(PayloadValidator.validateCreatePayload(toDo));
    }

    @Test
    public void validateInvalidPayLoad() {
        ToDo toDo = new ToDo(0, "Sample ToDo 1", true);
        assertTrue(PayloadValidator.validateCreatePayload(toDo));
    }

}