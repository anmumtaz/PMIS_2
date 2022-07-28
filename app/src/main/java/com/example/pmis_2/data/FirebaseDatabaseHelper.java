package com.example.pmis_2.data;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDatabaseHelper {

   private DatabaseReference reference;
   private FirebaseDatabase database;

   ArrayList<ProjectListData> projectListData = new ArrayList<>();

   public interface DataStatus{
      void dataIsLoad(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> keys);
      void dataIsUpdate();
      void dataIsDelete();
   }

   public FirebaseDatabaseHelper() {
      database = FirebaseDatabase.getInstance();
      reference = database.getReference("projects");
   }

   public void readProjectList(final DataStatus dataStatus){
      reference.addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            projectListData.clear();
            ArrayList<String> keys = new ArrayList<>();
            for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
               keys.add(dataSnapshot1.getKey());
               ProjectListData p = dataSnapshot1.getValue(ProjectListData.class);
               projectListData.add(p);
            }
            dataStatus.dataIsLoad(projectListData, keys);
         }

         @Override
         public void onCancelled(@NonNull DatabaseError databaseError) {}
      });
   }

   public void updateProject(String key, ProjectListData projectListData, final DataStatus dataStatus) {
      reference.child(key).setValue(projectListData).addOnSuccessListener(new OnSuccessListener<Void>() {
         @Override
         public void onSuccess(Void unused) {
            dataStatus.dataIsUpdate();
         }
      });
   }

   public void deleteProject(String key, final DataStatus dataStatus) {
      reference.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
         @Override
         public void onSuccess(Void unused) {
            dataStatus.dataIsDelete();
         }
      });
   }
}
