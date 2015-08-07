package com.novopay.sohammusicplayer;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sohammondal on 06/08/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MusicInstrumentationTests {
    @Rule
    public ActivityTestRule<ListOfMusicActivity> mainActivityActivityTestRule = new ActivityTestRule<>(ListOfMusicActivity.class);

    @Test
    public void testListView() {
        onView(withId(R.id.activity_viewpager_viewpager)).check(matches(isDisplayed()));
//        onView(withId(R.id.activity_main_play)).check(matches(isDisplayed()));
    }
}
