package org.example.services;

import org.example.data.model.Diary;
import org.example.data.repository.DiaryRepository;
import org.example.dtos.request.CreateEntryRequest;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.exceptions.IncorrectPasswordException;
import org.example.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryRepository diaryRepository ;
    @Autowired
    private EntryService entryService ;

    private int count;

    @Override
    public void register(RegisterRequest registerRequest) {
        Diary diary = new Diary();
        diary.setUserName(registerRequest.getUsername());
        diary.setPassWord(registerRequest.getPassword());
        diaryRepository.save(diary);
        count++;
    }

    @Override
    public int getNumberOfUsers() {
        return count;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        Optional<Diary> diary = diaryRepository.findById(username);
        if(diary.isEmpty()) throw new UserNotRegisteredException("User Not Found");
        if(!loginRequest.getPassword().equals(diary.get().getPassWord())) throw new IncorrectPasswordException("Incorrect password");
        if(!loginRequest.getUsername().equals(diary.get().getUserName())) throw new UserNotRegisteredException("User Not Registered");
        diary.get().setLocked(false);


    }

    @Override
    public Diary findUserBy(String username) {

        Optional<Diary> diary = diaryRepository.findById(username);
        return diary.get();
    }

    @Override
    public void createEntryWith(CreateEntryRequest createEntryRequest) {
        entryService.addEntry(createEntryRequest);
    }

    @Override
    public void logout(String username) {
        Optional<Diary> diary = diaryRepository.findById(username);
        //            throw new IncorrectPassword("Username is not valid");
        diary.get().setLocked(true);
    }

    @Override
    public void delete(int id) {
        entryService.delete(id);
    }


}
