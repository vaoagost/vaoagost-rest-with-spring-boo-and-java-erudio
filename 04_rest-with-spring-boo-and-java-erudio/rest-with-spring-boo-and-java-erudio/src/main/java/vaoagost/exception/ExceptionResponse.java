package vaoagost.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
    // This class is used to create a response for exceptions
    // It contains the timestamp, message and details of the exception
    // The record keyword is used to create a class with final fields and a constructor
    // The fields are automatically created as public getters
    // The record keyword is used to create a class with final fields and a constructor
    // The fields are automatically created as public getters
}
