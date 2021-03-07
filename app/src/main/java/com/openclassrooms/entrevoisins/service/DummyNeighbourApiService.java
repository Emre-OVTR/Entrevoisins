package com.openclassrooms.entrevoisins.service;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    public List<Neighbour> favorites =  new ArrayList<>();//Collections.emptyList();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavorites() {
        return favorites;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    @Override
    public void addFavorite(Neighbour neighbour) {


        boolean isInList = false;
        for ( Neighbour item : favorites){



            if ( item.getId() == neighbour.getId()){// id de l'item est present dans la liste isinliist = true
                isInList = true;
                break; // arrete la boucle
            }
            
        }
        if (!isInList){    // si item == false cela veut dire que l'id de l'item  n'est pas ds la liste donc ajoute en fav
            favorites.add(neighbour);
        }
    }

    @Override
    public void deleteFavorite(Neighbour neighbour) {
        favorites.remove(neighbour);
    }
}
