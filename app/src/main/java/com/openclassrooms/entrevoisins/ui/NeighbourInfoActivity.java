package com.openclassrooms.entrevoisins.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.Objects;

public class NeighbourInfoActivity extends AppCompatActivity {

    private Neighbour neighbour;
    private ImageView infoAvatar;
    private FloatingActionButton infoFavBtn;
    private TextView nameText;
    private TextView about;
    private TextView phone;
    private TextView address;
    private TextView detailNameText;
    

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        neighbour = (Neighbour) getIntent().getSerializableExtra("Editing");
        infoAvatar = findViewById(R.id.activity_info_avatar);
        infoFavBtn = findViewById(R.id.activity_info_fav_btn);
        nameText = findViewById(R.id.activity_info_name_text);
        about = findViewById(R.id.activity_info_about_text);
        phone = findViewById(R.id.activity_info_phone_text);
        address = findViewById(R.id.activity_info_address_text);
        detailNameText = findViewById(R.id.activity_detail_name_text);

        configureNeighbourDetails();
        configureAddToFavouritesButton();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void configureNeighbourDetails(){
        nameText.setText(neighbour.getName());
        detailNameText.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(infoAvatar);
        about.setText(neighbour.getAboutMe());
        phone.setText(neighbour.getPhoneNumber());
        address.setText(neighbour.getAddress());
    }
    public void configureAddToFavouritesButton(){
        mApiService = DI.getNeighbourApiService();
        infoFavBtn.setOnClickListener(v -> mApiService.addFavorite(neighbour));
    }


}