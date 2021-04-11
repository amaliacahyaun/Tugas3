package com.example.myrecylcerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder myHolder, int i) {

        myHolder.mNama.setText(models.get(i).getNama());
        myHolder.mImBendera.setImageResource(models.get(i).getImg());
        myHolder.mDet.setText(models.get(i).getDetail());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, com.example.myrecylcerview.AnotherActivity.class);
                intent.putExtra("iNama", models.get(i).getNama());
                intent.putExtra("iDetail",models.get(i).getDetail());
                intent.putExtra("iImage", models.get(i).getImg());
                c.startActivity(intent);
            }
        });
//            @Override
//            public void onItemClickListener(View v, int position)
//            {
//
//                String gNama = models.get(position).getNama();
//                String gDet = models.get(position).getDetail();
//
//                BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImBendera.getDrawable();
//
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 200, stream);
//
//                byte[] bytes = stream.toByteArray();
//
//                Intent intent = new Intent(c, com.example.myrecylcerview.AnotherActivity.class);
//                intent.putExtra("iNama", gNama);
//                intent.putExtra("iDetail",gDet);
//                intent.putExtra("iImage", bytes);
//                c.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView mImBendera;
        private TextView mNama;
        private TextView mDet;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mImBendera = itemView.findViewById(R.id.benderaN);
            mNama = itemView.findViewById(R.id.namaN);
            mDet = itemView.findViewById(R.id.detailN);
        }

    }
}
