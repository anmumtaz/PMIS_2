package com.example.pmis_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserAdapter extends FirebaseRecyclerAdapter<User, UserAdapter.UserViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, final int position, @NonNull User model) {
        holder.textViewName.setText(model.getName());
        holder.textViewEmail.setText(model.getEmail());
        holder.textViewPassword.setText(model.getPassword());
        holder.textViewUsertype.setText(model.getUsertype());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.textViewEmail.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updateuser_popup))
                        .setExpanded(true, 1200)
                        .create();
                //dialogPlus.show();

                view = dialogPlus.getHolderView();
                EditText name = view.findViewById(R.id.updateName);
                EditText email = view.findViewById(R.id.updateEmail);
                EditText pass = view.findViewById(R.id.updatePass);
                EditText utype = view.findViewById(R.id.updateUsertype);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                name.setText(model.getName());
                email.setText(model.getEmail());
                pass.setText(model.getPassword());
                utype.setText(model.getUsertype());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", name.getText().toString());
                        map.put("email", email.getText().toString());
                        map.put("password", pass.getText().toString());
                        map.put("usertype", utype.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("users")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.textViewEmail.getContext(), "Data Updated", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.textViewEmail.getContext(), "Error while Updating", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });


            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.textViewEmail.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        FirebaseDatabase.getInstance().getReference().child("users")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(holder.textViewEmail.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    public class UserViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewName, textViewEmail, textViewPassword, textViewUsertype;
        Button btnEdit, btnDelete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewEmail = itemView.findViewById(R.id.tvEmail);
            textViewPassword = itemView.findViewById(R.id.tvPassword);
            textViewUsertype = itemView.findViewById(R.id.tvUsertype);

            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
        }
    }
}
