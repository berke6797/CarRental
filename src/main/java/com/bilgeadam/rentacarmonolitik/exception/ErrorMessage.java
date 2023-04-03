package com.bilgeadam.rentacarmonolitik.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
/**
 * GlobalException'da yazdığımız gibi her exception içerisine hata mesajı ayrı ayrı loglanması yerine
 * bir tane error mesajı oluşturup onu exceptionların içersine veririz.
 */
public class ErrorMessage {
    int code;
    String message;
    List<String> fields;
}
