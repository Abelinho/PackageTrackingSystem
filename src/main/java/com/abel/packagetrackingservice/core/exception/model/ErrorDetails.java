package com.abel.packagetrackingservice.core.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class ErrorDetails  implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus code;
    private List<ValidationError> validation;

    public ErrorDetails(Date timestamp, String message, String details, HttpStatus code) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public ErrorDetails(Date timestamp, String message, String details, HttpStatus code, List<ValidationError> validation) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
        this.validation = validation;
    }

}
