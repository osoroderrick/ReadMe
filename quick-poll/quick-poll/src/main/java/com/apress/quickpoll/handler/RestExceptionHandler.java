package com.apress.quickpoll.handler;

import com.apress.quickpoll.apress.dto.error.ErrorDetail;
import com.apress.quickpoll.apress.dto.error.ValidationError;
import com.apress.quickpoll.apress.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resource_nfe, HttpServletRequest request){
        ErrorDetail error = new ErrorDetail();
        error.setDetail(resource_nfe.getMessage());
        error.setTitle("Resource Not Found");
        error.setStatus(404);
        error.setTimeStamp(new Date().getTime());
        error.setDeveloperMessage(resource_nfe.getStackTrace().toString());

        return new ResponseEntity<>(error,null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDetail handleValidationError(MethodArgumentNotValidException manve, HttpServletRequest request){
        ErrorDetail errorDetails = new ErrorDetail();

        List<FieldError> fieldErrors = manve.getBindingResult().getFieldErrors();

        for(FieldError fe : fieldErrors){
            List<ValidationError> validationErrorList = errorDetails.getErrors().get(fe.getField());

            if(validationErrorList == null){
                validationErrorList = new ArrayList<>();
                errorDetails.getErrors().put(fe.getField(), validationErrorList);
            }

            ValidationError validationError = new ValidationError();
            validationError.setCode(fe.getCode());
            validationError.setMessage(messageSource.getMessage(fe, null));
            validationErrorList.add(validationError);
        }
        return errorDetails;
    }
}

