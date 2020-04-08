package com.example.tema3.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.tema3.R;
import com.example.tema3.Fragments.ToDosFragment;



public class ToDoActivity extends AppCompatActivity {

    private ToDosFragment toDosFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        if(getIntent().getExtras() != null)
            moveToToDosFragment();

    }

    protected void moveToToDosFragment () {

        toDosFragment = new ToDosFragment();
        Bundle bundle = getIntent().getExtras();
        toDosFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.to_do_list, toDosFragment);
        fragmentTransaction.commit();

    }

}
