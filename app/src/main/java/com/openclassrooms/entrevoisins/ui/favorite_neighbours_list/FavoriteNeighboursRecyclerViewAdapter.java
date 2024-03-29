package com.openclassrooms.entrevoisins.ui.favorite_neighbours_list;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteFavoriteEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteNeighboursRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteNeighboursRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mFavorites;

    public FavoriteNeighboursRecyclerViewAdapter(List<Neighbour> items ){
        mFavorites = items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favorites, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mFavorites.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(v -> EventBus.getDefault().post(new DeleteFavoriteEvent(neighbour)));
    }

    @Override
    public int getItemCount() {
        return mFavorites.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView((R.id.item_list_avatar))
        public ImageView mNeighbourAvatar;
        @BindView((R.id.item_list_name))
        public TextView mNeighbourName;
        @BindView((R.id.item_list_delete_button))
        public ImageButton mDeleteButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
