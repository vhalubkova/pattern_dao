package org.example.services;

import java.util.Date;

public class AboutUserResultsDTO {
    Date data;
    String text;
    public AboutUserResultsDTO(Date data,String text){
        this.data = data;
        this.text = text;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
