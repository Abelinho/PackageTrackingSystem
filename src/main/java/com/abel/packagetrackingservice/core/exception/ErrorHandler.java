package com.abel.packagetrackingservice.core.exception;

import com.abel.packagetrackingservice.core.exception.model.ErrorDetails;
import com.abel.packagetrackingservice.dto.response.AppResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

import static com.abel.packagetrackingservice.util.AppUtil.sanitize;

@Order(Ordered.HIGHEST_PRECEDENCE)//Gives this component the highest precedence among other error handlers!
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PackageNotFoundException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handlePackageNotFoundException(PackageNotFoundException ex, WebRequest request) {

        ErrorDetails errorDetails =
                new ErrorDetails(new Date(), ex.getMessage(),
                        request.getDescription(true), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(sanitize(errorDetails.getCode().name()))
                .error(errorDetails)
                .build());
    }

    @ExceptionHandler(IllegalStatusException.class)
    public final ResponseEntity<AppResponse<ErrorDetails>> handleIllegalStateException(IllegalStatusException ex, WebRequest request) {

        ErrorDetails errorDetails =
                new ErrorDetails(new Date(), ex.getMessage(),
                        request.getDescription(true), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
                .message(ex.getMessage())
                .status(sanitize(errorDetails.getCode().name()))
                .error(errorDetails)
                .build());
    }
}
