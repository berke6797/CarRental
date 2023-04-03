package com.bilgeadam.rentacarmonolitik.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    CAR_NOT_FOUND(2004,"Araba bulunamadı", HttpStatus.NOT_FOUND),
    BRAND_NOT_FOUND(2007,"Marka bulunamadı", HttpStatus.NOT_FOUND),
    CUSTOMER_NOT_FOUND(2005,"Müşteri bulunamadı", HttpStatus.NOT_FOUND),
    COLOR_NOT_FOUND(2006,"Renk bulunamadı",HttpStatus.NOT_FOUND),
    BAD_REQUEST(4000,"Geçersiz istek yada parametre",HttpStatus.BAD_REQUEST),
    ERROR(9000,"Beklenmeyen bir hata oluştu. Lütfen tekrar deneyin",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_INVALID_TOKEN(3000,"Geçersiz token bilgisi",HttpStatus.UNAUTHORIZED);

    int code;
    String message;
    HttpStatus httpStatus;
}
