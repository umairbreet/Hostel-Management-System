package com.example.hostelmanagementsystem;


import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapterClass extends RecyclerView.Adapter<RoomAdapterClass.ViewHolder> {
    List<RoomModelClass> room;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public RoomAdapterClass(List<RoomModelClass> room, Context context) {
        this.room  = room;
        this.context = context;

        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.employee_item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RoomModelClass roomModelClass = room.get(position);

        holder.textViewID.setText(Integer.toString(roomModelClass.getId()));
        holder.editText_Name.setText(roomModelClass.getName());
        holder.editText_Email.setText(roomModelClass.getEmail());
        holder.editText_Contact.setText(roomModelClass.getContact());
        holder.editText_Contact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().startsWith("(+92)-")){
                    holder.editText_Contact.setText("(+92)-");
                    Selection.setSelection(holder.editText_Contact.getText(),
                                            holder.editText_Contact.getText().length());
                }
            }
        });
        holder.editText_RoomNo.setText(roomModelClass.getRoomNo());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = holder.editText_Name.getText().toString();
                String Email = holder.editText_Email.getText().toString();
                String Contact = holder.editText_Contact.getText().toString();
                String RoomNo = holder.editText_RoomNo.getText().toString();
                if ((!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches()))
                {
                    databaseHelperClass.updateRoom(new RoomModelClass(roomModelClass.getId(), Name, Email, Contact, RoomNo));
                    ((Activity) context).finish();
                    context.startActivity(((Activity) context).getIntent());
                }
                else
                {
                    holder.editText_Email.setError("Enter Correct Email");
                }
            }

        });

        holder.button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    databaseHelperClass.deleteRoom(Integer.valueOf(roomModelClass.getId()));
                    room.remove(position);
                    notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return room.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Contact;
        EditText editText_RoomNo;

        Button button_Edit;
        Button button_Delete;

        public ViewHolder( View itemView){
            super(itemView);
            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Contact = itemView.findViewById(R.id.edittext_contact);
            editText_RoomNo = itemView.findViewById(R.id.edittext_roomNo);

            button_Delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);
        }
    }
}

