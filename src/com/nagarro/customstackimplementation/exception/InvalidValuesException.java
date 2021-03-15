/*
* Class name: InvalidValuesException
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 12/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 12/Mar/2021
*
* Description: give description of the Exception
*/
package com.nagarro.customstackimplementation.exception;

public class InvalidValuesException extends RuntimeException {
    private static final String EXCEPTION = "Exception: ";

    /**
     * used to give the error message if any exception occurs
     * 
     * @param exceptionMessage
     */
    public InvalidValuesException(String exceptionMessage) {
        System.out.println(EXCEPTION + exceptionMessage);
    }
}
