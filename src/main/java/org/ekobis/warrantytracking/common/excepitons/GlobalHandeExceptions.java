package org.ekobis.warrantytracking.common.excepitons;

import org.ekobis.warrantytracking.common.result.ExceptionResponse;
import org.ekobis.warrantytracking.device.model.util.excepiton.NotFoundDeviceId;
import org.ekobis.warrantytracking.warranty.model.util.exception.ExistingDeviceException;
import org.ekobis.warrantytracking.warranty.model.util.exception.NotFoundWarrantId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandeExceptions {

    /**
     * Handles validation errors.
     *
     * @param e the MethodArgumentNotValidException
     * @return a ResponseEntity containing an ExceptionResponse with a "Validation Error" message and HTTP status BAD_REQUEST
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationErrors(MethodArgumentNotValidException e) {

        return new ResponseEntity<>(new ExceptionResponse("Validation Error"), HttpStatus.BAD_REQUEST);

    }

    /**
     * Handles NotFoundDeviceId exceptions.
     *
     * @param e the NotFoundDeviceId exception
     * @return a ResponseEntity containing an ExceptionResponse with the exception message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(NotFoundDeviceId.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundDeviceId(NotFoundDeviceId e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles ExistingDeviceException exceptions.
     *
     * @param e the ExistingDeviceException
     * @return a ResponseEntity containing an ExceptionResponse with the exception message and HTTP status BAD_REQUEST
     */
    @ExceptionHandler(ExistingDeviceException.class)
    public ResponseEntity<ExceptionResponse> handleExistingDeviceException(ExistingDeviceException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles NotFoundWarrantId exceptions.
     *
     * @param e the NotFoundWarrantId exception
     * @return a ResponseEntity containing an ExceptionResponse with the exception message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(NotFoundWarrantId.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundWarrantId(NotFoundWarrantId e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }


}
