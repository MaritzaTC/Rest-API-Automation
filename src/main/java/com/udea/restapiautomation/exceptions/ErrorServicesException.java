package com.udea.restapiautomation.exceptions;

public class ErrorServicesException extends RuntimeException  {
    public ErrorServicesException(String exceptionMessage){
        super(exceptionMessage);
    }
}
