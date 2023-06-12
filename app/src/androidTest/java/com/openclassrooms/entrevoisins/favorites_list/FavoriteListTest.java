package com.openclassrooms.entrevoisins.favorites_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.OpenViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class FavoriteListTest {

    private int ITEMS_COUNT = 0;
    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();

    }

    @Test
    public void favoriteListDisplaysOnlyFavoriteAddedItem() {

        onView(withContentDescription("Favorites")).perform(click());
        onView(withId(R.id.list_favorites)).check(withItemCount(ITEMS_COUNT));
        onView(withContentDescription("My neighbours")).perform(click());
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new OpenViewAction()));

        onView(ViewMatchers.withId(R.id.activity_info_fav_btn)).perform(click());

        pressBack();
        onView(withContentDescription("Favorites")).perform(click());


        onView(withId(R.id.list_favorites)).check(withItemCount(ITEMS_COUNT + 1));

    }

}
