package com.jsstech.quoteuserpanel;

import android.content.Intent;
import android.os.Bundle;



import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.jsstech.quoteuserpanel.ViewQuotes.QuotesList;
import com.jsstech.quoteuserpanel.ViewQuotes.VAttitude;
import com.jsstech.quoteuserpanel.ViewQuotes.VChange;
import com.jsstech.quoteuserpanel.ViewQuotes.VEducation;
import com.jsstech.quoteuserpanel.ViewQuotes.VFailure;
import com.jsstech.quoteuserpanel.ViewQuotes.VFaith;
import com.jsstech.quoteuserpanel.ViewQuotes.VFrienship;
import com.jsstech.quoteuserpanel.ViewQuotes.VHappiness;
import com.jsstech.quoteuserpanel.ViewQuotes.VHealth;
import com.jsstech.quoteuserpanel.ViewQuotes.VInspirational;
import com.jsstech.quoteuserpanel.ViewQuotes.VLeadership;
import com.jsstech.quoteuserpanel.ViewQuotes.VLife;
import com.jsstech.quoteuserpanel.ViewQuotes.VLove;
import com.jsstech.quoteuserpanel.ViewQuotes.VMotivational;
import com.jsstech.quoteuserpanel.ViewQuotes.VPatience;
import com.jsstech.quoteuserpanel.ViewQuotes.VPeace;
import com.jsstech.quoteuserpanel.ViewQuotes.VPositive;
import com.jsstech.quoteuserpanel.ViewQuotes.VPower;
import com.jsstech.quoteuserpanel.ViewQuotes.VRelationship;
import com.jsstech.quoteuserpanel.ViewQuotes.VSuccess;
import com.jsstech.quoteuserpanel.ViewQuotes.VTrust;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;

            case R.id.optionMenu_profile:
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_quote_list:
                Intent intent2 = new Intent(HomeActivity.this, QuotesList.class);
                startActivity(intent2);
                break;

            case R.id.nav_contactus:
                Intent intent = new Intent(HomeActivity.this, ContactUS.class);
                startActivity(intent);
                break;


            case R.id.nav_aboutus:
                Intent intent1 = new Intent(HomeActivity.this, AboutView.class);
                startActivity(intent1);
                break;

            case R.id.nav_inquiry:
                Intent intent3 = new Intent(HomeActivity.this, InquiryActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case R.id.nav_image_quotes:
                Intent intent5 = new Intent(HomeActivity.this, ImagesActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case R.id.nav_your_quotes:
                Intent intent6 = new Intent(HomeActivity.this, InsertYourQuotes.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case R.id.nav_share_app:
                Intent intent7 = new Intent(HomeActivity.this, ShareApp.class);
                startActivity(intent7);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.nav_rate_app:
                Intent intent8 = new Intent(HomeActivity.this, RateApp.class);
                startActivity(intent8);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void quotesMotivational(View view) {
        startActivity(new Intent(HomeActivity.this, VMotivational.class));
    }

    public void quotesInpirational(View view) {
        startActivity(new Intent(HomeActivity.this, VInspirational.class));
    }

    public void quotesSuccess(View view) {
        startActivity(new Intent(HomeActivity.this, VSuccess.class));
    }

    public void quotesPositive(View view) {
        startActivity(new Intent(HomeActivity.this, VPositive.class));
    }


    public void quotesLeadership(View view) {
        startActivity(new Intent(HomeActivity.this, VLeadership.class));
    }

    public void quotesLife(View view) {
        startActivity(new Intent(HomeActivity.this, VLife.class));
    }

    public void quotesLove(View view) {
        startActivity(new Intent(HomeActivity.this, VLove.class));
    }

    public void quotesAttitude(View view) {
        startActivity(new Intent(HomeActivity.this, VAttitude.class));
    }

    public void quotesChange(View view) {
        startActivity(new Intent(HomeActivity.this, VChange.class));
    }

    public void quotesPatience(View view) {
        startActivity(new Intent(HomeActivity.this, VPatience.class));
    }

    public void quotesPeace(View view) {
        startActivity(new Intent(HomeActivity.this, VPeace.class));
    }

    public void quotesEducation(View view) {
        startActivity(new Intent(HomeActivity.this, VEducation.class));
    }

    public void quotesRelationship(View view) {
        startActivity(new Intent(HomeActivity.this, VRelationship.class));
    }

    public void quotesFailure(View view) {
        startActivity(new Intent(HomeActivity.this, VFailure.class));
    }

    public void quotesFaith(View view) {
        startActivity(new Intent(HomeActivity.this, VFaith.class));
    }

    public void quotesPower(View view) {
        startActivity(new Intent(HomeActivity.this, VPower.class));
    }

    public void quotesFriendship(View view) {
        startActivity(new Intent(HomeActivity.this, VFrienship.class));
    }

    public void quotesHappiness(View view) {
        startActivity(new Intent(HomeActivity.this, VHappiness.class));
    }

    public void quotesHealth(View view) {
        startActivity(new Intent(HomeActivity.this, VHealth.class));
    }

    public void quotesTrust(View view) {
        startActivity(new Intent(HomeActivity.this, VTrust.class));
    }
}
