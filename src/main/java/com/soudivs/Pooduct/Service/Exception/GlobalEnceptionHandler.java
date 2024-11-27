package com.soudivs.Pooduct.Service.Exception;

import com.soudivs.Pooduct.Service.DTO.ApiResponse;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

@RestControllerAdvice
public class GlobalEnceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setTimestamp(Time.from(Instant.now()));
        apiResponse.setStatus(false);

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND) ;
    }

}
