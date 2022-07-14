package com.example.pmis_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;


public class ProjectInfoAdapter extends FirebaseRecyclerAdapter<ProjectInfo, ProjectInfoAdapter.ProjectInfoViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public ProjectInfoAdapter(@NonNull FirebaseRecyclerOptions<ProjectInfo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProjectInfoViewHolder holder, int position, @NonNull ProjectInfo model) {
        holder.projectName.setText(model.getProject_name());
        holder.itemView.setOnClickListener(view -> {

        })
    }

    @NonNull
    @Override
    public ProjectInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projectlist, parent, false);
        return new ProjectInfoViewHolder(view);
    }

    public class ProjectInfoViewHolder extends RecyclerView.ViewHolder{
        TextView projectName;

        public ProjectInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            projectName = (TextView)itemView.findViewById(R.id.projectnamelist);
        }
    }

}