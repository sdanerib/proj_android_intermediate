package com.example.macintosh.myduolingo.models;

import java.io.Serializable;

/**
 * Created by macintosh on 2/5/18.
 */

/*
{
    "langAbbr": "SPA",
    "created": 1521949801098,
    "available": true,
    "langName": "Spanish",
    "langFlagResource": "images/flag_sp.png",
    "id": 1,
    "ownerId": null,
    "updated": 1521949904223,
    "objectId": "23AFC15B-4D08-F72E-FFF4-96D85C01C800",
    "___class": "LanguagesToLearn"
}
*/

public class LanguageToLearnEntity implements Serializable{

    private int id;
    private String langAbbr;
    private String langName;
    private String langFlagRes;
    private Boolean available;

    public LanguageToLearnEntity(int id, String langAbbr, String langName, String langFlagRes, boolean available) {
        this.id = id;
        this.langAbbr = langAbbr;
        this.langName = langName;
        this.langFlagRes = langFlagRes;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangAbbr() {
        return langAbbr;
    }

    public void setLangAbbr(String langAbbr) {
        this.langAbbr = langAbbr;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getLangFlagRes() {
        return langFlagRes;
    }

    public void setLangFlagRes(String langFlagRes) {
        this.langFlagRes = langFlagRes;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
