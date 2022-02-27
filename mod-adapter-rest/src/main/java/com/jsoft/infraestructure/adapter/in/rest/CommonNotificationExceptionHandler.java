package com.jsoft.infraestructure.adapter.in.rest;

import com.jsoft.common.exception.AbstractDomainException;
import com.jsoft.domain.exception.DomainResponseCode;
import com.jsoft.infraestructure.adapter.in.rest.model.Notification;
import com.jsoft.infraestructure.adapter.in.rest.model.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class CommonNotificationExceptionHandler {

    @ExceptionHandler(AbstractDomainException.class)
    public ResponseEntity<ResponseBody> handleAbstractNotificationException(
            AbstractDomainException ex) {

        ApiResponseCode responseCode = ApiResponseCode.of((DomainResponseCode) ex.getApiResponseCode());
        Notification notification = new Notification()
                .description(responseCode.getDescription())
                .code(responseCode.getCode());

        log.error(String.format("Error response detail: [HttpCode: %s] [Code: %s] [Description: %s] [Message: %s]",
                responseCode.getHttpStatus().value() ,notification.getCode(), notification.getDescription(), ex.getMessage()),
                ex);

        return ResponseEntity
                .status(responseCode.getHttpStatus())
                .body(new ResponseBody().notification(notification));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseBody> handleAbstractNotificationException(
        ConstraintViolationException ex) {

        ApiResponseCode responseCode = ApiResponseCode.of("ERR-02", "Invalid request data");
        Notification notification = new Notification()
                .description(responseCode.getDescription())
                .code(responseCode.getCode());

        log.error(String.format("Error response detail: [HttpCode: %s] [Code: %s] [Description: %s] [Message: %s]",
                responseCode.getHttpStatus().value() ,notification.getCode(), notification.getDescription(), ex.getMessage()),
                ex);

        return ResponseEntity
                .status(responseCode.getHttpStatus())
                .body(new ResponseBody().notification(notification));
    }
}
