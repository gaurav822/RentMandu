package com.example.rentmandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import User_Fragments.User_Accounts;
import User_Fragments.User_dashboard;
import User_Fragments.User_explore;
import User_Fragments.User_inbox;
import User_Fragments.User_notifications;
import de.hdodenhof.circleimageview.CircleImageView;

public class Homepage extends AppCompatActivity {


    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        chipNavigationBar=findViewById(R.id.bottom_nav_view);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_dashboard,true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new User_dashboard()).commit();

        bottommenu();
    }

    private void bottommenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i){

                    case R.id.bottom_nav_dashboard:
                        fragment=new User_dashboard();
                        break;

                    case R.id.bottom_nav_inbox:
                        fragment=new User_inbox();
                        break;

                    case R.id.bottom_nav_search:
                        fragment=new User_explore();
                        break;

                    case R.id.bottom_nav_notify:
                        fragment=new User_notifications();
                        break;

                    case R.id.bottom_nav_account:
                        fragment=new User_Accounts();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}