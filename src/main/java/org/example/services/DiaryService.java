package org.example.services;

import org.example.data.model.Diary;
import org.example.dtos.request.CreateEntryRequest;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface DiaryService {

    void register(RegisterRequest registerRequest);
    int getNumberOfUsers();

    void login(LoginRequest loginRequest);

    Diary findUserBy(String username);

    void createEntryWith(CreateEntryRequest createEntryRequest);

    void logout(String username);

    void delete(int id);


}
