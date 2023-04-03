package com.bilgeadam.rentacarmonolitik.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorMessage createErrorMessage(ErrorType errorType,Exception exception){
        System.out.println("Bu kısımda hata mesajlarının loglama işlemlerini yapmalıyız");
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    @ExceptionHandler(RentACarException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerJava7MonoException(RentACarException exception){
        System.out.println("RentACarException hatası.....: "+ exception.toString());
     //   return ResponseEntity.ok(exception.getMessage());
        return new ResponseEntity(createErrorMessage(exception.getErrorType(),exception),exception.getErrorType().getHttpStatus());
    }


    @ExceptionHandler(ArithmeticException.class)  // İstisnanın dinlenmesini sağlar
    @ResponseBody
    public ResponseEntity<String> handleArithmeticException(ArithmeticException exception){

        System.out.println("Aritmetik hatası...: "+exception.toString()); // Konsolda görmek için
        return ResponseEntity.ok("Sıfıra bölme işlemi hatası"); // Bu kullanıcıya dönecektir
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    public final ResponseEntity<ErrorMessage> handleMissingPathVariableException(MissingPathVariableException exception){
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }

    //    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseEntity<String> handleException(Exception exception){
//        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oluştu. Lütfen daha sonra tekrar deneyiniz.");
//    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(Exception exception){
        ErrorType errorType = ErrorType.ERROR;
        return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }


    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorMessage> handleInvalidFormatException(
            InvalidFormatException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MethodArgumentTypeMismatchException exception) {

        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        List<String> fields = new ArrayList<>();
        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createErrorMessage(errorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, errorType.getHttpStatus());
    }


}
