package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.macintosh.myduolingo.ui.OnFragmentInteractionListener;
import com.example.macintosh.myduolingo.ui.fragments.ClubsFragment;
import com.example.macintosh.myduolingo.ui.fragments.ConfigFragment;
import com.example.macintosh.myduolingo.ui.fragments.Fragment1;
import com.example.macintosh.myduolingo.ui.fragments.Fragment2;
import com.example.macintosh.myduolingo.ui.fragments.Fragment3;
import com.example.macintosh.myduolingo.ui.fragments.LearnFragment;
import com.example.macintosh.myduolingo.ui.fragments.ProfileFragment;
import com.example.macintosh.myduolingo.ui.fragments.ShareProgressFragment;
import com.example.macintosh.myduolingo.ui.fragments.SuggestionsFragment;

public class UserSessionDashboard extends AppCompatActivity implements OnFragmentInteractionListener {

    Intent navIntent;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    //private LanguageToLearnEntity languageToLearnObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session_dashboard);
//        getUserSessionInfo();
        ui();
    }

//    private void getUserSessionInfo() {
//        navIntent = getIntent();
//        //languageToLearnObj = (LanguageToLearnEntity) navIntent.getSerializableExtra("STUDIED_LANGUAGE");
//    }

    private void ui() {
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        TextView tviLangToBeLearned = findViewById(R.id.tviToolBarTitle);
        //tviLangToBeLearned.setText(languageToLearnObj.getLangName());
        tviLangToBeLearned.setText("Inglés");

        // - - DRAWER - -
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){

                    case R.id.menu1:
                        changeFragment(0);
                        return true;

                    case R.id.menu2:
                        changeFragment(1);
                        return true;

                    case R.id.menu3:
                        changeFragment(2);
                        return true;

                    default:
                        return true;
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                switch (item.getItemId()){

                    case R.id.learnBar:
                        changeFragment(6);
                        return true;

                    case R.id.profileBar:
                        changeFragment(7);
                        return true;

                    case R.id.clubBar:
                        changeFragment(8);
                        return true;

                    default:
                        return true;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.language_progress_menu, menu);
        return true;
    }

    private void changeFragment(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = (Fragment) new Fragment1();
                break;
            case 1:
                fragment = (Fragment) new Fragment2();
                break;
            case 2:
                fragment = (Fragment) new Fragment3();
                break;
            case 3:
                fragment = (Fragment) new ConfigFragment();
                break;
            case 4:
                fragment = (Fragment) new ShareProgressFragment();
                break;
            case 5:
                fragment = (Fragment) new SuggestionsFragment();
                break;
            case 6:
                fragment = (Fragment) new LearnFragment();
                break;
            case 7:
                fragment = (Fragment) new ProfileFragment();
                break;
            case 8:
                fragment = (Fragment) new ClubsFragment();
                break;
        }
        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment);
            fragmentTransaction.commit();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.dashboardMoreOptions:
                Log.d("MENU", "CONFIGURATIONS");
                changeFragment(3);
                return true;

            case R.id.shareProgress:
                Log.d("MENU", "SHARE PROGRESS");
                changeFragment(4);
                return true;

            case R.id.suggestions:
                Log.d("MENU", "SUGGESTIONS");
                changeFragment(5);
                return true;

            case R.id.closeSession:
                Log.d("MENU", "CLOSE SESSION");
                navIntent = new Intent(this, LoginActivity.class);
                startActivity(navIntent);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
