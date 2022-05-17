package com.mostbet.triggerCampaign.web.controller.advices;

import com.mostbet.triggerCampaign.web.controller.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity<Object> handleInteractionException(Exception e, WebRequest request) {
        if (e instanceof NotFoundException) {
            log.error(e.getMessage(), e);

            return
                    ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(e.getMessage())
                    ;
        }

        return
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e.getMessage())
                ;
    }
}
