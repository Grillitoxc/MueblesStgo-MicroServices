package Tingeso2Microservices.clockservice.service;

public class UploadTimestampsException extends RuntimeException {
    public UploadTimestampsException(String message) {
        super(message);
    }

    public UploadTimestampsException(String message, Throwable cause) {
        super(message, cause);
    }
}
