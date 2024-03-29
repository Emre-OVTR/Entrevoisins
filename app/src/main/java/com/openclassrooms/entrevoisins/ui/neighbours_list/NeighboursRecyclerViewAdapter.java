package com.openclassrooms.entrevoisins.ui.neighbours_list;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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
import com.openclassrooms.entrevoisins.events.OpenNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighboursRecyclerViewAdapter extends RecyclerView.Adapter<NeighboursRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;

    public NeighboursRecyclerViewAdapter(List<Neighbour> items)  {
        mNeighbours = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(v -> EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour)));

        holder.mConstraintLayout.setOnClickListener(v -> EventBus.getDefault().post(new OpenNeighbourEvent(neighbour)));
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView((R.id.item_list_avatar))
        public ImageView mNeighbourAvatar;
        @BindView((R.id.item_list_name))
        public TextView mNeighbourName;
        @BindView((R.id.item_list_delete_button))
        public ImageButton mDeleteButton;
        @BindView((R.id.fragment_neighbour_layout))
        public ConstraintLayout mConstraintLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
