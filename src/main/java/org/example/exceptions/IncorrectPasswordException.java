package org.example.exceptions;

public class IncorrectPasswordException extends DiaryAppException{
    public IncorrectPasswordException(String statement){
        super(statement);
    }
}
