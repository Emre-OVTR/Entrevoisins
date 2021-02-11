package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class OpenNeighbourEvent {

    public Neighbour neighbour;

    public OpenNeighbourEvent(Neighbour neighbour){
        this.neighbour = neighbour;
    }

}
