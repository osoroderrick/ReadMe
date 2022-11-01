package com.apress.quickpoll.apress.model;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "OPTIONS_ID",nullable = false)
    private Long id;

    @Column(name="OPTIONS_VALUE",nullable = false)
    private String value;

    public Options() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
