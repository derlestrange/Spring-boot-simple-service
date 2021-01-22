package com.example.demo.util;

import com.example.demo.model.ToDo;

public class PayloadValidator {

    public static boolean validateCreatePayload(ToDo toDo){
        if (toDo.getId() > 0){
            return false;
        }
        return true;
    }
}
