package com.amo.labs.lab3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ErrorsDAO {
    List<InterPoltionError> errors = new ArrayList<>();

    public ErrorsDAO(){

    }

    public List<InterPoltionError> getErrors() {
        return errors;
    }

    public void save(InterPoltionError error){
        errors.add(error);
    }
}
