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
import com.example.tema3.Adapters.UserAdapter;
import com.example.tema3.Models.User;
import com.example.tema3.MySingleton;
import com.example.tema3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UsersFragment extends Fragment {

    private UserAdapter adapter;
    private RecyclerView recyclerView;
    private List<User> users;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.users_recycler_view, container, false);

        setRecyclerView(view);
        getUsers();

        return view;
    }

    private void getUsers() {

        String url = "https://my-json-server.typicode.com/MoldovanG/JsonServer/users?fbclid=IwAR11exFAbH8YDRDSwnNnUlp5GHBMfsAhdlvQ_zMT69vtOQcpfZMuTpZO9gc";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int index = 0; index < response.length(); index++) {
                    try {
                        JSONObject userJSON = response.getJSONObject(index);
                        users.add(new User().fromJSON(userJSON));
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

    private void setRecyclerView(View view) {

        users = new ArrayList<>();

        recyclerView = view.findViewById(R.id.usersRecycleView);
        adapter = new UserAdapter(users, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
