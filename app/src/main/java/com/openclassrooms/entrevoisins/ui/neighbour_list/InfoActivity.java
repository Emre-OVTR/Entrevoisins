package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.OpenNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;

import org.greenrobot.eventbus.EventBus;

public class InfoActivity extends AppCompatActivity {

    private ImageView mInfoAvatar;
    private FloatingActionButton mInfoFavBtn;
    private TextView mNameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mInfoAvatar = findViewById(R.id.activity_info_avatar);
        mInfoFavBtn = findViewById(R.id.activity_info_fav_btn);
        mNameText = findViewById(R.id.activity_info_name_text);

        Neighbour neighbour= (Neighbour) getIntent().getSerializableExtra("Editing");

        mNameText.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mInfoAvatar);

    }

}