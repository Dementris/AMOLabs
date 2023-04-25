package com.amo.labs.lab3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ErrorsDAO {
    List<InterPoltionError> errors = new ArrayList<>();
    double xi = 0;

    public ErrorsDAO(){

    }

    public List<InterPoltionError> getErrors() {
        return errors;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public void save(InterPoltionError error){
        errors.add(error);
    }
}
