package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public interface NeighbourApiService {


    List<Neighbour> getNeighbours();
    List<Neighbour> getFavorites();

    void deleteNeighbour(Neighbour neighbour);

    void createNeighbour(Neighbour neighbour);

    void addFavorite(Neighbour neighbour);

    void deleteFavorite(Neighbour neighbour);


}
