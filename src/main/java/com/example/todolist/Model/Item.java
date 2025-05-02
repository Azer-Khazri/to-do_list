package com.example.todolist.Model;

import java.time.LocalDate;

public class Item {
    private String shortDescription;
    private String details;
    private String category;
    private LocalDate deadline;

    public Item(String shortDescription, String details, String category, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.category = category;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}