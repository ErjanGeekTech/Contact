package com.example.contact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MainViewHolder> {

    Activity activity;
    ArrayList <ContactsModel> arrayList;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MainAdapter(Activity activity, ArrayList<ContactsModel> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ContactsModel model = arrayList.get(position);
        holder.txtName.setText(model.getName());
        holder.txtNumber.setText(model.getNumber());
        holder.bind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_name);
            txtNumber = itemView.findViewById(R.id.tv_number);
        }

        public void bind(ContactsModel contactsModel) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.moveInter(getAdapterPosition());
                }
            });
        }
    }
}
