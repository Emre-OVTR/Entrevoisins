
package com.openclassrooms.entrevoisins.neighbour_list;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.MainActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.OpenViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;




@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {


    private static int ITEMS_COUNT = 12;
    private MainActivity mActivity;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }


    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }


    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));

        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));

        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    @Test
    public void myNeighboursList_openAction_shouldStartInfoActivity() {

        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new OpenViewAction()));

        onView(withId(R.id.activity_info_name_text)).check(matches(isDisplayed()));
    }

    @Test
    public void nameText_shouldNotBeEmpty() {

        onView(withId(R.id.list_neighbours)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new OpenViewAction()));

        onView(withId(R.id.activity_info_name_text)).check(matches(withText("Jack")));
    }


}