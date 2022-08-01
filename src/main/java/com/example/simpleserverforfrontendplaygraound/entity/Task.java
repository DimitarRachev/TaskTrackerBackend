package com.example.simpleserverforfrontendplaygraound.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String text;

    @Column(nullable = false)
    private String day;

    @Column
    private boolean reminder;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Task setText(String text) {
        this.text = text;
        return this;
    }

    public String getDay() {
        return day;
    }

    public Task setDay(String day) {
        this.day = day;
        return this;
    }

    public boolean isReminder() {
        return reminder;
    }

    public Task setReminder(boolean reminder) {
        this.reminder = reminder;
        return this;
    }
}
