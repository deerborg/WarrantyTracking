package org.ekobis.warrantytracking.device.model.util.excepiton;

public class NotFoundDeviceId extends RuntimeException {
    public NotFoundDeviceId(String message) {
        super(message);
    }
}
