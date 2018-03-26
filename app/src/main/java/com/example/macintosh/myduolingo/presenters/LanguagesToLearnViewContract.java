package com.example.macintosh.myduolingo.presenters;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;
import com.example.macintosh.myduolingo.storage.network.entities.LanguageToLearnResponse;
import com.example.macintosh.myduolingo.storage.network.entities.LanguagesToLearnFullResponse;

/**
 * Created by Stephany Daneri on 3/25/18.
 */

public interface LanguagesToLearnViewContract {

    void renderAllLanguageToLearn(LanguagesToLearnFullResponse languageToLearnResponse);
    void showErrorMsg();
    //void showLoading();
    //void hideLoading();
}
