package com.example.simpleserverforfrontendplaygraound.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String text;
    private String day;
    private boolean reminder;

    public String getText() {
        return text;
    }

    public TaskDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getDay() {
        return day;
    }

    public TaskDto setDay(String day) {
        this.day = day;
        return this;
    }

    public boolean isReminder() {
        return reminder;
    }

    public TaskDto setReminder(boolean reminder) {
        this.reminder = reminder;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TaskDto setId(Long id) {
        this.id = id;
        return this;
    }
}
