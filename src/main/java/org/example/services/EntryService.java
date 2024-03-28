package org.example.services;

import org.example.data.model.Entry;
import org.example.dtos.request.CreateEntryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EntryService {
    List<Entry> getEntriesFor(String username);

    Entry createNewEntryWith(String username);

    void delete(int id);
    void addEntry(CreateEntryRequest createEntryRequest);

    int getNumberOfEntries();
}
