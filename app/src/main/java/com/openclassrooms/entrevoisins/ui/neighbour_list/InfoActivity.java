package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.AddFavoriteEvent;
import com.openclassrooms.entrevoisins.events.OpenNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;

import butterknife.OnClick;

public class InfoActivity extends AppCompatActivity {

    private ImageView mInfoAvatar;
    private FloatingActionButton mInfoFavBtn;
    private TextView mNameText;

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mInfoAvatar = findViewById(R.id.activity_info_avatar);
        mInfoFavBtn = findViewById(R.id.activity_info_fav_btn);
        mNameText = findViewById(R.id.activity_info_name_text);

        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra("Editing");

        mNameText.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mInfoAvatar);

        mApiService = DI.getNeighbourApiService();




        mInfoFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            mApiService.addFavorite(neighbour);
                finish();
            }
        });

    }


}