package com.darayuth.journal.app.controller;

import com.darayuth.journal.app.entity.Journal;
import com.darayuth.journal.app.service.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Todo make the layout look good
// then published the app
// then add to resume
// apply for job .

@Controller
//@RequestMapping(value = {"/" , "/journals"})
public class journalController {
    private JournalService journalService;

    public journalController(JournalService journalService) {
        this.journalService = journalService;
    }


    /***
     * Database is working.
     * @param theModel
     * @return
     */
    @GetMapping("/journals/list")
    public String listJournal(Model theModel){
       List<Journal> theJournals = journalService.findAll();

        theModel.addAttribute("journals", theJournals);
        return "Journal/list_journal";
    }

    /**
     *
     * @param theModel the index route
     * @return journal-form index.html
     */
    @GetMapping("/")
    public String indexForm(Model theModel){
        Journal theJournal = new Journal();
        theModel.addAttribute("journal", theJournal);
        return "index";
    }
    // Todo create delete route to
    // delete the items after display from
    // database

    @PostMapping("/journals/delete")
    public String journalDelete(@RequestParam("journal_id") int journal_id){
        journalService.deleteById(journal_id);

        //always redirect route after performing post mapping.
        return "redirect:/journals/list";
    }

    // Todo create Update route
    @PostMapping("/journals/update")
    public String update(@RequestParam("journal_id") int journal_id, Model theModel){
        Journal theJournal = this.journalService.findById(journal_id);
        theModel.addAttribute("journal", theJournal);

        return "index";
    }

    /**
     *
     * @return the journal_form html.
     * have to create model to binding form
     */
    @GetMapping("/journals/journal_form")
    public String journalForm(Model theModel){
        Journal theJournal = new Journal();
        theModel.addAttribute("journal", theJournal);
        return "index";
    }

    /**
     *
     *
     * @Todo save does not work. i have to fix it.
     * @thesolution is the createing binding form inside
     * the get JournalForm method.
     *
     * @Solution fixed.
     */
    @PostMapping("/journals/save")
    public String save(@ModelAttribute Journal theJournal){
        journalService.save(theJournal);
        return "redirect:/journals/list";
    }
}
