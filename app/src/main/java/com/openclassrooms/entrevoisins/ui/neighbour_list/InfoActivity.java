package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private ImageView mInfoAvatar;
    private FloatingActionButton mInfoFavBtn;
    private TextView mNameText;
    private TextView mAbout;
    private TextView mPhone;
    private TextView mAddress;
    private TextView mDetailNameText;
    

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mInfoAvatar = findViewById(R.id.activity_info_avatar);
        mInfoFavBtn = findViewById(R.id.activity_info_fav_btn);
        mNameText = findViewById(R.id.activity_info_name_text);
        mAbout = findViewById(R.id.activity_info_about_text);
        mPhone = findViewById(R.id.activity_info_phone_text);
        mAddress = findViewById(R.id.activity_info_address_text);
        mDetailNameText = findViewById(R.id.activity_detail_name_text);


        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra("Editing");


        mNameText.setText(neighbour.getName());
        mDetailNameText.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mInfoAvatar);
        mAbout.setText(neighbour.getAboutMe());
        mPhone.setText(neighbour.getPhoneNumber());
        mAddress.setText(neighbour.getAddress());


        mApiService = DI.getNeighbourApiService();




        mInfoFavBtn.setOnClickListener(v -> mApiService.addFavorite(neighbour));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}