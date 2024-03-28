package org.example.services;

import org.example.data.model.Entry;
import org.example.data.repository.EntryRepository;
import org.example.dtos.request.CreateEntryRequest;
import org.example.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;
    private int count;


    @Override
    public List<Entry> getEntriesFor(String username) {
        return null;
//        return entryRepository.findEntriesFor(username);
    }

    @Override
    public Entry createNewEntryWith(String username) {
        Entry newEntry = new Entry();
        newEntry.setAuthor(username);
        return newEntry;
    }

    @Override
    public void delete(int id) {
        Optional<Entry> entry = entryRepository.findById(String.valueOf(id));
        if (entry.isEmpty()) throw new UserNotRegisteredException("No user found");
        entryRepository.delete(entry.get());


    }


    @Override
    public void addEntry( CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        entry.setAuthor(createEntryRequest.getUsername());
        entry.setBody(createEntryRequest.getBody());
        entry.setTitle(createEntryRequest.getTitle());
        entryRepository.save(entry);

    }

    @Override
    public int getNumberOfEntries() {
        return count+1;
    }
}
