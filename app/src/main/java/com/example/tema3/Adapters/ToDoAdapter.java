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

import com.example.tema3.Activities.CreateAlarmActivity;
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

        setText(holder, position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreateAlarmActivity.class);
                intent.putExtra("id", toDos.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    private void setText(ViewHolder holder, int position) {

        holder.title.setText(toDos.get(position).getTitle());
        Boolean completed = toDos.get(position).getCompleted();

        if (completed) {
            holder.completedResponse.setTextColor(Color.BLUE);
            holder.completedResponse.setText("YES");
        }
        else {
            holder.completedResponse.setTextColor(Color.RED);
            holder.completedResponse.setText("NO");
        }

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
        TextView completedResponse;
        TextView id;
        ConstraintLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            completedResponse = itemView.findViewById(R.id.completedResponse);
            container = itemView.findViewById(R.id.to_do);
        }
    }
}
