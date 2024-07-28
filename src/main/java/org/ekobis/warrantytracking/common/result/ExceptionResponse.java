package org.ekobis.warrantytracking.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private boolean status = false;

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
