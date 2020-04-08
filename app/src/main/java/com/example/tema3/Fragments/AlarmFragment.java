package com.example.tema3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tema3.R;

public class AlarmFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.show_buttons, container, false);

        Button timePicker = view.findViewById(R.id.time_picker);
        Button datePicker = view.findViewById(R.id.date_picker);
        Button createAlarm = view.findViewById(R.id.create_alarm);

        return view;
    }
}
