package com.example.hostelmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {
    List<TimeModel> time;
    Context context;
    DateTimeDatabase dateTimeDatabase;

    public TimeAdapter(List<TimeModel> time, Context context) {
        this.time = time;
        this.context = context;
        dateTimeDatabase = new DateTimeDatabase(context);
    }

    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.date_time,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.ViewHolder holder, int position) {
        final TimeModel timeModel = time.get(position);

        holder.textViewID.setText(Integer.toString(timeModel.getId()));
        holder.dateTime.setText(timeModel.getDate());
    }

    @Override
    public int getItemCount() {
        return time.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewID;
        TextView    dateTime;
        public ViewHolder(View itemView) {
            super(itemView);
            {
                textViewID = itemView.findViewById(R.id.textID);
                dateTime = itemView.findViewById(R.id.dTime);
            }
        }
    }
}
