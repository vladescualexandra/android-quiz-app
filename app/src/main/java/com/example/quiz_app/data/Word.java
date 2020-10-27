package com.example.quiz_app.data;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Word implements Serializable {

    private int id;
    private String url;
    private String english;
    private String italian;
    private String spanish;
    private String french;

    public Word(int id, String url, String english, String italian, String spanish, String french) {
        this.id = id;
        this.url = url;
        this.english = english;
        this.italian = italian;
        this.spanish = spanish;
        this.french = french;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getEnglish() {
        return english;
    }

    public String getItalian() {
        return italian;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getFrench() {
        return french;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " : " + url + ": " + english + " : " + italian + "/" + spanish + "/" + french;
    }
}
