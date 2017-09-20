package com.example.subramani_5647.simplecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> webLoginActivityTestRule = new IntentsTestRule<MainActivity>(MainActivity.class,false, true)
    {
        @Override
        protected void afterActivityLaunched()
        {

        }

        @Override
        protected Intent getActivityIntent()
        {
            return super.getActivityIntent();
        }
    };

    // Default generated test
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.subramani_5647.simplecalculator", appContext.getPackageName());
    }

    @Test
    public void checkVisibility()
    {
        onView(withId(R.id.leftOperand)).check(matches(isDisplayed()));
        onView(withId(R.id.rightOperand)).check(matches(isDisplayed()));


    }

}
