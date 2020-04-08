package com.example.tema3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema3.Activities.ToDoActivity;
import com.example.tema3.Models.User;
import com.example.tema3.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_user, parent, false);
        return new ViewHolder(view);
    }

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.username.setText(users.get(position).getUsername());
        holder.userId.setText(Integer.toString(users.get(position).getId()));
        holder.email.setText("Email: " + users.get(position).getEmail());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = users.get(position).getId();
                Intent intent = new Intent(context, ToDoActivity.class);
                intent.putExtra("userId", userId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView userId;
        TextView email;
        ConstraintLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            userId = itemView.findViewById(R.id.user_id);
            container = itemView.findViewById(R.id.linearLayout);
            email = itemView.findViewById(R.id.email);
        }
    }
}
