package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;


@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;




    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getFavoritesWithSuccess() {
        List<Neighbour> favorites = service.getFavorites();
        List<Neighbour> expectedFavorites = new ArrayList<>();
        assertThat(favorites, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavorites.toArray()));
    }

    @Test

    public void addFavoritesWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavorite(neighbour);
        assertTrue(service.getFavorites().contains(neighbour));
    }

    @Test
    public void deleteFavoriteWithSuccess() {

        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavorite(neighbour);
        service.getFavorites().get(0);
        service.deleteFavorite(neighbour);
        assertFalse(service.getFavorites().contains(neighbour));


    }

    @Test
    public void addFavoritesOnceWithSuccess(){
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavorite(neighbour);
        service.addFavorite(neighbour);
        assertTrue(service.getFavorites().contains(neighbour));
        assertEquals(service.getFavorites().size(), 1);


    }


    @Test
    public void deleteNeighbourFromMyNeighboursAndFavoritesWithSuccess(){
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavorite(neighbour);
        service.getNeighbours().get(0);
        service.deleteNeighbour(neighbour);
        assertFalse(service.getFavorites().contains(neighbour));
        assertEquals(service.getFavorites().size(),0);
    }

}
