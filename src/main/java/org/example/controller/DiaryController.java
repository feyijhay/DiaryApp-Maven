package org.example.controller;

import org.example.dtos.request.CreateEntryRequest;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.exceptions.DiaryAppException;
import org.example.services.DiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {
    @Autowired
    private  DiaryServiceImpl diaryServices ;


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        try{
            diaryServices.register(registerRequest);
            return "Successful";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }


    public String login(LoginRequest loginRequest){
        try {
            diaryServices.login(loginRequest);
            return "Logged Successfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    public String logout(String username){
        try{
            diaryServices.logout(username);
            return "logged out succesfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    public String findUserBy(String username){
        try{
            diaryServices.findUserBy(username);
            return "user found";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    public String createEntryWith(CreateEntryRequest createEntryRequest){
        try {
            diaryServices.createEntryWith(createEntryRequest);
            return "Entry created successfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }

    }

    public String delete(int id){
        try {
            diaryServices.delete(id);
            return "Deleted successfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

}
