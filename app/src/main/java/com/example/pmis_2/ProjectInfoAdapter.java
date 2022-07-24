package com.example.pmis_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class ProjectInfoAdapter extends FirebaseRecyclerAdapter<ProjectListData, ProjectInfoAdapter.ProjectInfoViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public ProjectInfoAdapter(@NonNull FirebaseRecyclerOptions<ProjectListData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProjectInfoViewHolder holder, int position, @NonNull ProjectListData model) {
        holder.projectName.setText(model.getProject_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @NonNull
    @Override
    public ProjectInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_admin_project_list, parent, false);
        return new ProjectInfoViewHolder(view);
    }

    public class ProjectInfoViewHolder extends RecyclerView.ViewHolder{
        TextView projectName;

        public ProjectInfoViewHolder(@NonNull View itemView) {
            super(itemView);
//            projectName = (TextView)itemView.findViewById(R.id.projectnamelist);
        }
    }

}