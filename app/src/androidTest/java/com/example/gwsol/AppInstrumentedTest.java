package com.example.gwsol;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AppInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.gwsol", appContext.getPackageName());
    }

    @Test
    public void loginTextTest() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.firstname)).perform(typeText("admin"));
        activityScenario.close();
    }


    @Test
    public void loginTest() throws IOException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.executeShellCommand("settings put global window_animation_scale 0");
        device.executeShellCommand("settings put global transition_animation_scale 0");
        device.executeShellCommand("settings put global animator_duration_scale 0");

        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.firstname)).perform(typeText("admin"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_nextpage_plants)).perform(click());
        onView(withId(R.id.password)).perform(typeText("12345"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.buttonnextpge)).perform(click());
        onView(withId(R.id.textView3)).check(matches(withText("Уход за которыми вы можете изучить")));
    }


    @Test
    public void infoLentaTest() throws IOException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.executeShellCommand("settings put global window_animation_scale 0");
        device.executeShellCommand("settings put global transition_animation_scale 0");
        device.executeShellCommand("settings put global animator_duration_scale 0");

        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.firstname)).perform(typeText("admin"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_nextpage_plants)).perform(click());
        onView(withId(R.id.password)).perform(typeText("12345"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.buttonnextpge)).perform(click());
        onView(withId(R.id.textView3)).check(matches(withText("Уход за которыми вы можете изучить")));
        onView(withId(R.id.recview)).perform(click());
        onView(withId(R.id.discription)).check(matches(withText("Показатели растения на данный момент")));
    }


    @Test
    public void addNewPlantTest() throws IOException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.executeShellCommand("settings put global window_animation_scale 0");
        device.executeShellCommand("settings put global transition_animation_scale 0");
        device.executeShellCommand("settings put global animator_duration_scale 0");

        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.firstname)).perform(typeText("admin"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_nextpage_plants)).perform(click());
        onView(withId(R.id.password)).perform(typeText("12345"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.buttonnextpge)).perform(click());
        onView(withId(R.id.textView3)).check(matches(withText("Уход за которыми вы можете изучить")));
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.addbttn)).perform(click());
        onView(withId(R.id.textView4)).check(matches(withText("Для продолжение назовите растение")));
    }

}