package com.darayuth.journal.app.dao;

import com.darayuth.journal.app.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRespository extends JpaRepository<Journal, Integer> {
    // add a method to sort by last name

}
