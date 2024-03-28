package org.example.exceptions;

public class DiaryAppException extends RuntimeException {

    public DiaryAppException(String statement){
        super(statement);
    }
}
