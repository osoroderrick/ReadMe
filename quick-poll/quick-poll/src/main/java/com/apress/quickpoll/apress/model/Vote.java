package com.apress.quickpoll.apress.model;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
public class Vote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="VOTE_ID",nullable = false)
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name ="OPTIONS_ID",nullable = false)
    private Options options;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Options getOption() {
        return options;
    }

    public void setOption(Options option) {
        this.options = option;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", option=" + options +
                '}';
    }
}
