package com.example.pmis_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmis_2.screen.AdminProjectDetails;

import java.util.ArrayList;

public class ProjectListConfig {

   private Context mContext;
   private ProjectListAdapter projectAdminAdapter;

   public void setConfig(RecyclerView recyclerView, Context context,
                         ArrayList<ProjectListData> toDoArrayList, ArrayList<String> keys)
   {
      mContext = context;
      projectAdminAdapter = new ProjectListAdapter(toDoArrayList, keys);
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.setAdapter(projectAdminAdapter);
   }

   class ProjectListAdapter extends RecyclerView.Adapter<ProjectListViewHolder> {

      private ArrayList<ProjectListData> projectAdminArrayList;
      private ArrayList<String> mKeys;

      public ProjectListAdapter(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> mKeys) {
         this.projectAdminArrayList = projectListDataArrayList;
         this.mKeys = mKeys;
      }


      @NonNull
      @Override
      public ProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new ProjectListViewHolder(parent);
      }

      @Override
      public void onBindViewHolder(@NonNull ProjectListViewHolder holder, int position) {
         holder.bind(projectAdminArrayList.get(position), mKeys.get(position));

      }

      @Override
      public int getItemCount() {return projectAdminArrayList.size();}
   }

   class ProjectListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

      private TextView projectNameTextView;
      private String key;
      private ProjectListData projectListData;

      public ProjectListViewHolder(ViewGroup parent) {
         super(LayoutInflater.from(mContext).inflate(R.layout.view_holder_admin_project_list, parent, false));

         projectNameTextView = itemView.findViewById(R.id.viewHolderProjectNameTextView);

         itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intentProjectDetails = new Intent(mContext, AdminProjectDetails.class);
               intentProjectDetails.putExtra("key", key);
//               intentProjectDetails.putParcelableArrayListExtra("data", projectListData);

               mContext.startActivity(intentProjectDetails);
            }
         });
      }

      public void bind(ProjectListData projectListData, String key) {
         projectNameTextView.setText(projectListData.getProject_name());

         this.projectListData = projectListData;
         this.key = key;
      }

      @Override
      public void onClick(View view) {
//         R.id.viewHolderProjectNameTextView =
      }
   }
}

interface ProjectListListener {
   void onItemClickedListener(ProjectListData projectListData);
}
