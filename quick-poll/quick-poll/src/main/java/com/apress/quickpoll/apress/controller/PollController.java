package com.apress.quickpoll.apress.controller;

import com.apress.quickpoll.apress.exception.ResourceNotFoundException;
import com.apress.quickpoll.apress.model.Poll;
import com.apress.quickpoll.apress.repository.PollRepository;
import com.apress.quickpoll.apress.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
public class PollController {


    @Autowired
    private PollService pollService;


    @RequestMapping(value="/polls", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return  pollService.getAllPolls();
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    @RequestMapping(value="/polls", method=RequestMethod.POST)
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return pollService.updatePoll(poll,pollId);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return pollService.deletePoll(pollId);
    }
//    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
//    public void verifyPoll(Long pollId) {
//       pollService.verifyPoll(pollId);
//    }
}
