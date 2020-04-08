package com.example.tema3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tema3.Fragments.UsersFragment;
import com.example.tema3.R;

public class MainActivity extends AppCompatActivity {

    private UsersFragment usersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveToUsersFragment();

    }

    protected void moveToUsersFragment() {

        usersFragment = new UsersFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, usersFragment);
        fragmentTransaction.commit();

    }
}
