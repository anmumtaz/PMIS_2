package com.example.pmis_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmis_2.data.ProjectListData;

import java.util.ArrayList;
import java.util.List;

public class ProjectListConfig {

   private Context mContext;
   private ProjectListAdapter projectAdminAdapter;

   public void setConfig(RecyclerView recyclerView, Context context,
                         ArrayList<ProjectListData> toDoArrayList, ArrayList<String> keys,
                         ProjectItemListener itemClickListener)
   {
      mContext = context;
      projectAdminAdapter = new ProjectListAdapter(toDoArrayList, keys, itemClickListener);
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      recyclerView.setAdapter(projectAdminAdapter);
   }

   public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

      private final List<ProjectListData> items;
      private ArrayList<String> mKeys;
      private final ProjectItemListener listener;

      public ProjectListAdapter(List<ProjectListData> items, ArrayList<String> mKeys, ProjectItemListener listener) {
         this.items = items;
         this.mKeys = mKeys;
         this.listener = listener;
      }

      @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_admin_project_list, parent, false);
         return new ViewHolder(v);
      }

      @Override public void onBindViewHolder(ViewHolder holder, int position) {
         holder.bind(items.get(position), mKeys.get(position) ,listener);
      }

      @Override public int getItemCount() {
         return items.size();
      }

      class ViewHolder extends RecyclerView.ViewHolder {

         private TextView projectNameTextView;
         private String key;

         public ViewHolder(View itemView) {
            super(itemView);
            projectNameTextView = (TextView) itemView.findViewById(R.id.viewHolderProjectNameTextView);
         }

         public void bind(final ProjectListData item, String keys, final ProjectItemListener listener) {
            projectNameTextView.setText(item.getProject_name());
            itemView.setOnClickListener(new View.OnClickListener() {
               @Override public void onClick(View v) {
                  listener.onItemClicked(item);
               }
            });

            this.key = keys;
         }
      }
   }
}
