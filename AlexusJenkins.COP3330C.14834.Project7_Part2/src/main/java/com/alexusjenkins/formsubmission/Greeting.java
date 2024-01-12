/*
Name: Alexus Jenkins
Course: COP 3330C
Date: November 12th, 2023
Program Objective: Create a Form Submission Application

Purpose: Defines the Greeting Object
 */

package com.alexusjenkins.formsubmission;

import java.time.LocalDate;

public class Greeting {

    private long id;
    private String content;
    private LocalDate date;

    // Getters and setters for the fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }
}

