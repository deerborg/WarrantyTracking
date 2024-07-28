package org.ekobis.warrantytracking.warranty.model.util.exception;

public class NotFoundWarrantId extends RuntimeException{
    public NotFoundWarrantId(String message) {
        super(message);
    }
}
