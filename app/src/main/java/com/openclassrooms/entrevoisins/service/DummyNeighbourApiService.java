package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;


public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    public List<Neighbour> favorites =  new ArrayList<>();


    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavorites() {
        return favorites;
    }


    @Override
    public void deleteNeighbour(Neighbour neighbour) {

        boolean isInList = false;

        for ( Neighbour item : favorites){

            if (item.getId() == neighbour.getId()){
                isInList = true;
                break;
            }
        }

        if (!isInList){
            neighbours.remove(neighbour);
        }

        if (isInList){
            favorites.remove(neighbour);
        }



    }


    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    @Override
    public void addFavorite(Neighbour neighbour) {


        boolean isInList = false;
        for ( Neighbour item : favorites){



            if ( item.getId() == neighbour.getId()){
                isInList = true;
                break;
            }
            
        }
        if (!isInList){
            favorites.add(neighbour);
        }

    }

    @Override
    public void deleteFavorite(Neighbour neighbour) {
        favorites.remove(neighbour);
    }
}
