package com.example.neotechhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(@NonNull final Adapter.ViewHolder holder, final int position) {
        holder.name.setText(""+mydata.get(position).getName());
        holder.surname.setText(mydata.get(position).getSurname());
        holder.email.setText(""+mydata.get(position).getEmail());
        holder.dob.setText(""+mydata.get(position).getDob());
//        holder.gender.setText("Gender- "+mydata.get(position).getGender());
//        holder.address.setText("Address- "+mydata.get(position).getAddress());
        holder.contact.setText(""+mydata.get(position).getContact());
//        holder.stream.setText("Stream- "+mydata.get(position).getStream());
//        holder.college.setText("College- "+mydata.get(position).getCollege());
//        holder.gettoknow.setText("GettoKnow- "+mydata.get(position).getGettoknow());
//        holder.course.setText("Course- "+mydata.get(position).getCourse());


        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, StudentDetail.class);
                i.putExtra("name",""+mydata.get(position).getName());
                i.putExtra("surname",""+mydata.get(position).getSurname());
                i.putExtra("email",""+mydata.get(position).getEmail());
                i.putExtra("gender",""+mydata.get(position).getGender());
                i.putExtra("address",""+mydata.get(position).getAddress());
                i.putExtra("contact",""+mydata.get(position).getContact());
                i.putExtra("stream",""+mydata.get(position).getStream());
                i.putExtra("college",""+mydata.get(position).getCollege());
                i.putExtra("gettoknow",""+mydata.get(position).getGettoknow());
                i.putExtra("course",""+mydata.get(position).getCourse());
                i.putExtra("image",""+mydata.get(position).getImage());
                i.putExtra("dob",""+mydata.get(position).getDob());
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,surname,email,dob,gender,address,contact,stream,college,gettoknow,course;
        CircleImageView im;
        CardView click;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            email=itemView.findViewById(R.id.email);
            dob=itemView.findViewById(R.id.dob);
            click=itemView.findViewById(R.id.card);
//            gender=itemView.findViewById(R.id.gender);
//            address=itemView.findViewById(R.id.address);
            contact=itemView.findViewById(R.id.contact);
            surname=itemView.findViewById(R.id.surname);
//            stream=itemView.findViewById(R.id.stream);
//            college=itemView.findViewById(R.id.college);
//            gettoknow=itemView.findViewById(R.id.gettoknow);
            course=itemView.findViewById(R.id.course);
            im = itemView.findViewById(R.id.image);
        }
    }
}