package com.example.tema3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tema3.R;
import com.example.tema3.Models.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends  RecyclerView.Adapter<ToDoAdapter.ViewHolder>  {

    private List<ToDo> toDos = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_to_do, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(toDos.get(position).getTitle());
        holder.id.setText(Integer.toString(toDos.get(position).getId()));
        Boolean completed = toDos.get(position).getCompleted();
        if (completed) {
            holder.completed.setTextColor(Color.GREEN);
            holder.completed.setText("Completed");
        }
        else {
            holder.completed.setTextColor(Color.BLUE);
            holder.completed.setText("Not completed");
        }
        /*
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotificationActivity.class);
                intent.putExtra("title", toDos.get(position).getTitle());
                context.startActivity(intent);
            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }


    public ToDoAdapter(List<ToDo> toDos, Context context) {
        this.toDos = toDos;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView completed;
        TextView id;
        ConstraintLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            completed = itemView.findViewById(R.id.completed);
            id = itemView.findViewById(R.id.to_do_id);
            container = itemView.findViewById(R.id.to_do);
        }
    }
}
