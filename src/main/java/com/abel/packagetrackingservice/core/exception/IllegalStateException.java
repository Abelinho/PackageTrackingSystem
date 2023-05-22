package com.abel.packagetrackingservice.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid value passed")
@EqualsAndHashCode(callSuper = false)
public class IllegalStateException extends RuntimeException {

    public IllegalStateException(String message) {
        super(message);
    }
}
