package com.example.demo;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
public class PlayerNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    PlayerNotFoundException(Integer id) {
        super("Could not find player " + id);
    }
}
