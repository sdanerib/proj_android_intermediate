package com.example.macintosh.myduolingo.storage.network.entities;

/**
 * Created by Stephany Daneri on 3/25/18.
 */


/*
[
	{
		"langAbbr": "JAP",
		"created": 1521950283618,
		"available": true,
		"langName": "Japanese",
		"langFlagResource": "images/flag_ja.png",
		"id": 7,
		"ownerId": null,
		"updated": 1521950302010,
		"objectId": "0B12AE59-4DC4-451C-FF42-E37B8F117B00",
		"___class": "LanguagesToLearn"
	}
]
*/

public class LanguageToLearnResponse {
    private String message;
    private String code;

    private String langAbbr;
    private String available;
    private String langName;
    private String langFlagResource;

    private String objectId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLangAbbr() {
        return langAbbr;
    }

    public void setLangAbbr(String langAbbr) {
        this.langAbbr = langAbbr;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getLangFlagResource() {
        return langFlagResource;
    }

    public void setLangFlagResource(String langFlagResource) {
        this.langFlagResource = langFlagResource;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

}
