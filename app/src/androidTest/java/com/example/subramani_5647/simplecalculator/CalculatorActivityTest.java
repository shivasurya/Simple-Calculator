package com.example.subramani_5647.simplecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorActivityTest {

    private static final int PLUS_BUTTON      = R.id.plus;
    private static final int MINUS_BUTTON     = R.id.minus;
    private static final int MULTIPLY_BUTTON  = R.id.multiply;
    private static final int DIVIDE_BUTTON    = R.id.divide;

    private static final int LEFT_OPERAND = R.id.leftOperand;
    private static final int RIGHT_OPERAND = R.id.rightOperand;

    private static final int LEFT_OPERAND_LABEL = R.id.leftOperandLabel;
    private static final int RIGHT_OPERAND_LABEL = R.id.rightOperandLabel;

    private static final int RESULT_FIELD = R.id.result;

    private static final int CALCBUTTON = R.id.wa_website_button;

    @Rule
    public IntentsTestRule<MainActivity> webLoginActivityTestRule = new IntentsTestRule<MainActivity>(MainActivity.class,false, true)
    {
        @Override
        protected void afterActivityLaunched()
        {

        }
    };

    @Before
    public void setUp()
    {
        Intents.init();
    }

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
        onView(withId(LEFT_OPERAND)).check(matches(isDisplayed()));
        onView(withId(RIGHT_OPERAND)).check(matches(isDisplayed()));

        onView(withId(PLUS_BUTTON)).check(matches(isDisplayed()));
        onView(withId(MINUS_BUTTON)).check(matches(isDisplayed()));
        onView(withId(MULTIPLY_BUTTON)).check(matches(isDisplayed()));
        onView(withId(DIVIDE_BUTTON)).check(matches(isDisplayed()));
        onView(withId(RESULT_FIELD)).check(matches(isDisplayed()));

        // Hidden
        //onView(withId(R.id.wa_website_button)).check(matches(not(isDisplayed())));

        //Visible
        onView(withId(CALCBUTTON)).perform(scrollTo());
        onView(withId(CALCBUTTON)).check(matches(isDisplayed()));

        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void buttonClickable()
    {
        onView(withId(PLUS_BUTTON)).check(matches(isEnabled()));
        onView(withId(MINUS_BUTTON)).check(matches(isEnabled()));
        onView(withId(MULTIPLY_BUTTON)).check(matches(isEnabled()));
        onView(withId(DIVIDE_BUTTON)).check(matches(isEnabled()));
        onView(withId(CALCBUTTON)).check(matches(isEnabled()));

        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void addTest()
    {
        onView(withId(LEFT_OPERAND))
                .perform(click())
                .perform(typeText("5"));

        onView(withId(RIGHT_OPERAND))
                .perform(click())
                .perform(typeText("3"));

        onView(withId(PLUS_BUTTON))
                .check(matches(isEnabled()))
                .perform(click());

        onView(withId(RESULT_FIELD))
                .check(matches(withText("8.0")));

        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    @Test
    public void minusTest()
    {
        onView(withId(LEFT_OPERAND))
                .perform(click())
                .perform(typeText("5"));

        onView(withId(RIGHT_OPERAND))
                .perform(click())
                .perform(typeText("3"));

        onView(withId(MINUS_BUTTON))
                .check(matches(isEnabled()))
                .perform(click());

        onView(withId(RESULT_FIELD))
                .check(matches(withText("2.0")));

        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void clearButtonTest()
    {
        onView(withId(RESULT_FIELD))
                .check(matches(isEnabled()))
                .perform(click());

        onView(withId(RESULT_FIELD))
                .check(matches(withText(R.string.result)));

        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void goToCalcsite()
    {
        onView(withId(CALCBUTTON)).perform(scrollTo());

        onView(withId(CALCBUTTON))
                .perform(click());

        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        intended(hasComponent(webViewCalculator.class.getName()));
    }

    @After
    public void tearDown()
    {
        Intents.release();
    }
}
