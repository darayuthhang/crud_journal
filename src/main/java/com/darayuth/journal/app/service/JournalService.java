package com.darayuth.journal.app.service;

import com.darayuth.journal.app.entity.Journal;

import java.util.List;

public interface JournalService {
    public void save(Journal theJournal);
    public List<Journal> findAll();
    public void deleteById(int journal_id);
    public Journal findById(int journal_id);
}
