package com.darayuth.journal.app.service;

import com.darayuth.journal.app.dao.JournalRespository;
import com.darayuth.journal.app.entity.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {

    private JournalRespository journalRespository;

    public JournalServiceImpl(JournalRespository journalRespository) {
        this.journalRespository = journalRespository;
    }

    @Override
    public void save(Journal theJournal) {
        this.journalRespository.save(theJournal);
    }

    @Override
    public List<Journal> findAll() {
       return this.journalRespository.findAll();
    }


    @Override
    public void deleteById(int journal_id) {
        this.journalRespository.deleteById(journal_id);
    }

    @Override
    public Journal findById(int journal_id) {
        //check for the option instance.
        Optional<Journal> result = this.journalRespository.findById(journal_id);
        Journal theJournal = null;
        //if there is the instance
        // instantiate the instance for result
        if(result.isPresent()){
            theJournal = result.get();
        }else{
            throw new RuntimeException("Did not find any Journal" + journal_id);
        }
        return theJournal;
    }
}
