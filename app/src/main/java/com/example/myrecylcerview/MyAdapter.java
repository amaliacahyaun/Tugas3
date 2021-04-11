package com.example.myrecylcerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<com.example.myrecylcerview.MyHolder> {

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public com.example.myrecylcerview.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new com.example.myrecylcerview.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.myrecylcerview.MyHolder myHolder, int i) {

        myHolder.mNama.setText(models.get(i).getNama());
        myHolder.mDet.setText(models.get(i).getDetail());
        myHolder.mImBendera.setImageResource(models.get(i).getImg());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position)
            {

                String gNama = models.get(position).getNama();
                String gDet = models.get(position).getDetail();

                BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImBendera.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.JPEG, 200, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c, com.example.myrecylcerview.AnotherActivity.class);
                intent.putExtra("iNama", gNama);
                intent.putExtra("iDetail",gDet);
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
