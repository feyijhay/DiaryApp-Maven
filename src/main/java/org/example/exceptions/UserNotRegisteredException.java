package org.example.exceptions;

public class UserNotRegisteredException extends DiaryAppException{
    public UserNotRegisteredException (String statement){
        super(statement);
    }
}
