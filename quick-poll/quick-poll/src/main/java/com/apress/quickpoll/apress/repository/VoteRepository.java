package com.apress.quickpoll.apress.repository;

import com.apress.quickpoll.apress.model.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote,Long> {


    @Query(value="select v.* from Options o, Vote v where o.POLL_ID = ?1 and v.OPTIONS_ID = o.OPTIONS_ID", nativeQuery = true)
    public Iterable<Vote> findByPoll(Long pollId);
}
