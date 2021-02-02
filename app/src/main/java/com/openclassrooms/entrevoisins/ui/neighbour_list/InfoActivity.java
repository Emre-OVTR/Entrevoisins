package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

public class InfoActivity extends AppCompatActivity {

    private ImageView mInfoAvatar;
    private FloatingActionButton mInfoFavBtn;
    private TextView mInfoNameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mInfoAvatar = findViewById(R.id.activity_info_avatar);
        mInfoFavBtn = findViewById(R.id.activity_info_fav_btn);
        mInfoNameText = findViewById(R.id.activity_info_name_text);
    }
}