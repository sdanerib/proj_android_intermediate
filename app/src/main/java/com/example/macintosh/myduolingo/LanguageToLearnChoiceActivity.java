package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;
import com.example.macintosh.myduolingo.presenters.LanguagesToLearnPresenter;
import com.example.macintosh.myduolingo.presenters.LanguagesToLearnViewContract;
import com.example.macintosh.myduolingo.storage.LanguageToLearnData;
import com.example.macintosh.myduolingo.storage.network.entities.LanguagesToLearnFullResponse;
import com.example.macintosh.myduolingo.storage.preferences.PreferencesHelper;
import com.example.macintosh.myduolingo.ui.ClickListener;
import com.example.macintosh.myduolingo.ui.RecyclerTouchListener;
import com.example.macintosh.myduolingo.ui.adapters.DuolingoBehaviourInterface;
import com.example.macintosh.myduolingo.ui.adapters.LanguageCoursesAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LanguageToLearnChoiceActivity extends AppCompatActivity implements DuolingoBehaviourInterface, LanguagesToLearnViewContract {

    private Intent navIntent;
    private RecyclerView recyclerViewLanguagesToLearn;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private LanguageToLearnData dataEntry;
    private ArrayList<LanguageToLearnEntity> languageToLearnEntityList;
    private LanguageCoursesAdapter languageCoursesAdapter;

    public String TAG = "LANGUAGE_CHOICE";
    private LanguagesToLearnPresenter languagesToLearnPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_to_learn_choice);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadLanguageCourses();
        ui();

    }

    private void loadLanguageCourses() {
        dataEntry = new LanguageToLearnData();

        //IMPLEMENTACION ORIGINAL
        //languageToLearnEntityList = dataEntry.generateLanguagesList();
        //dataEntry.logAllArrayElements(languageToLearnEntityList);
        //renderLanguageCoursesList();

        //IMPLEMENTACIÓN CON REST API
        languagesToLearnPresenter = new LanguagesToLearnPresenter();
        languagesToLearnPresenter.attachView(this);
        languagesToLearnPresenter.loadLanguagesFromBackendless();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    private void renderLanguageCoursesList() {
        dataEntry.logAllArrayElements(languageToLearnEntityList);
        languageCoursesAdapter = new LanguageCoursesAdapter(languageToLearnEntityList, this, this);
        recyclerViewLanguagesToLearn.setAdapter(languageCoursesAdapter);
    }

    @Override
    public void renderAllLanguageToLearn(LanguagesToLearnFullResponse languageToLearnResponse) {
        languageToLearnEntityList = languageToLearnResponse;
        languageCoursesAdapter = new LanguageCoursesAdapter(languageToLearnResponse, this, this);
        recyclerViewLanguagesToLearn.setAdapter(languageCoursesAdapter);
    }

    private void ui() {
        recyclerViewLanguagesToLearn = findViewById(R.id.recyclerViewLanguages);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerViewLanguagesToLearn.setLayoutManager(recyclerLayoutManager);

        recyclerViewLanguagesToLearn.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewLanguagesToLearn, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                try{
                   LanguageToLearnEntity languageToLearn = languageToLearnEntityList.get(position);
                   goToDailyGoalSettings(languageToLearn);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    private void goToDailyGoalSettings(LanguageToLearnEntity chosenLanguageToLearn) {
        PreferencesHelper.saveChosenLang(this, chosenLanguageToLearn.getLangName());

        navIntent = new Intent(this, DailyGoalActivity.class);
        navIntent.putExtra("CHOSEN_LANG_TO_LEARN", (Serializable) chosenLanguageToLearn);
        startActivity(navIntent);
    }

    @Override
    public void showErrorMsg() {
        Log.d(TAG, "HUBO UN ERROR...");
    }

}
