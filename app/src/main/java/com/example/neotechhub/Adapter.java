package com.example.neotechhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    View v;
    Context context;
    List<EnquiryModel> mydata;

          public Adapter(Context context, List<EnquiryModel> mydata) {
            this.context = context;
            this.mydata = mydata;
        }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter
                ,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.name.setText(mydata.get(position).getName());
        holder.surname.setText(mydata.get(position).getSurname());
        holder.email.setText(mydata.get(position).getEmail());
        holder.dob.setText(mydata.get(position).getDob());
        holder.gender.setText(mydata.get(position).getGender());
        holder.address.setText(mydata.get(position).getAddress());
        holder.contact.setText(mydata.get(position).getContact());
        holder.stream.setText(mydata.get(position).getStream());
        holder.college.setText(mydata.get(position).getCollege());
        holder.gettoknow.setText(mydata.get(position).getGettoknow());
        holder.course.setText(mydata.get(position).getCourse());



    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,surname,email,dob,gender,address,contact,stream,college,gettoknow,course;
        ImageView im;
        RelativeLayout click;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            email=itemView.findViewById(R.id.email);
            dob=itemView.findViewById(R.id.dob);
            gender=itemView.findViewById(R.id.gender);
            address=itemView.findViewById(R.id.address);
            contact=itemView.findViewById(R.id.contact);
            surname=itemView.findViewById(R.id.surname);
            stream=itemView.findViewById(R.id.stream);
            college=itemView.findViewById(R.id.college);
            gettoknow=itemView.findViewById(R.id.gettoknow);
            course=itemView.findViewById(R.id.course);
            im = itemView.findViewById(R.id.image);
        }
    }
}