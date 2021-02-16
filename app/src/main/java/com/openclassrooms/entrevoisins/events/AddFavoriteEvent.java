package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class AddFavoriteEvent {

    public Neighbour favorite;


    public AddFavoriteEvent (Neighbour favorite){
        this.favorite = favorite;
    }
}
