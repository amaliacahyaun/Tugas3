package com.example.myrecylcerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mNamaN, mDetN;
    ImageView mImBendera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        ActionBar actionBar = getSupportActionBar();

        mNamaN = findViewById(R.id.negara);
        mDetN = findViewById(R.id.detail);
        mImBendera = findViewById(R.id.imageView);

        Intent intent = getIntent();

        String mNama = intent.getStringExtra("iNama");
        String mDetail = intent.getStringExtra("iDetail");
        byte[] mBytes = getIntent().getByteArrayExtra("iImage");

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionBar.setTitle(mNama);

        mNamaN.setText(mNama);
        mDetN.setText(mDetail);
        mImBendera.setImageBitmap(bitmap);
    }
}