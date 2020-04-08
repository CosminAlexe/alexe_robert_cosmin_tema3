package com.example.tema3.Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tema3.Fragments.AlarmFragment;
import com.example.tema3.Fragments.UsersFragment;
import com.example.tema3.R;

public class CreateAlarmActivity extends AppCompatActivity {

    private AlarmFragment alarmFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        if(getIntent().getExtras() != null)
            moveToAlarmFragment();

    }

    protected void moveToAlarmFragment(){

        alarmFragment = new AlarmFragment();
        Bundle bundle = getIntent().getExtras();
        alarmFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, alarmFragment);
        fragmentTransaction.commit();

    }
}
