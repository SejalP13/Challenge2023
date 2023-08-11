package com.training.loggingtesting.customersdemo.exception;

public class CustomerNotFoundException extends Exception {


    public CustomerNotFoundException(String message) {
        super(message);
    }
}
//    public CustomerNotFoundException(String message) {
//        super(message);
//    }
//
//    public CustomerNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public CustomerNotFoundException(Throwable cause) {
//        super(cause);
//    }
//
//    protected CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
//}
//
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//public class CustomerNotFoundException extends RuntimeException {
//
//    private static final long serialVersionUID = 1L;
//    @Getter
//    private String resourceName;
//    @Getter private String fieldName;
//    @Getter private Object fieldValue;
//
//    public CustomerNotFoundException( String resourceName, String fieldName, Object fieldValue) {
//        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
//        this.resourceName = resourceName;
//        this.fieldName = fieldName;
//        this.fieldValue = fieldValue;
//    }
//
//}
