package org.ekobis.warrantytracking.common.result;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DataResponse <T> {

    private boolean status = true;

    private String message;

    private T data;

    public DataResponse(String message,T data) {
        this.data = data;
        this.message = message;
    }
}
