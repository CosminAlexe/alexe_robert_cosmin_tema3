package com.example.tema3.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.tema3.Adapters.ToDoAdapter;
import com.example.tema3.Models.ToDo;
import com.example.tema3.R;
import com.example.tema3.MySingleton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ToDosFragment extends Fragment {

    private ToDoAdapter adapter;
    private RecyclerView recyclerView;
    private List<ToDo> toDos;
    private  int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.to_dos_recycle_view, container, false);

        toDos = new ArrayList<>();

        recyclerView = view.findViewById(R.id.to_do_recycler_view);
        adapter = new ToDoAdapter(toDos, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle bundle = getArguments();
        if (getArguments() != null)
            userId = bundle.getInt("userId");

        getToDos();

        return view;
    }

    private void getToDos() {
        String url = "https://jsonplaceholder.typicode.com/todos?userId=" + String.valueOf(userId);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int index = 0; index < response.length(); index++) {
                    try {
                        JSONObject toDoItemJSON = response.getJSONObject(index);
                        toDos.add(new ToDo().fromJSON(toDoItemJSON));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "VolleyError: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);

    }

}
