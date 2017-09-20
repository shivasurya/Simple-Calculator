package com.example.subramani_5647.simplecalculator;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webKeys;

/**
 * Created by surya-5034 on 20/09/17.
 */

@RunWith(AndroidJUnit4.class)
public class webViewActivitytest {
    @Rule
    public IntentsTestRule<webViewCalculator> webLoginActivityTestRule = new IntentsTestRule<webViewCalculator>(webViewCalculator.class,false, true)
    {
        @Override
        protected void afterActivityLaunched()
        {

        }
    };

    @Test
    public void loginZoho()
    {
        onWebView()
                .withElement(findElement(Locator.ID, "lid"))
                .perform(clearElement())
                .perform(webKeys("sample"))
                .withElement(findElement(Locator.ID, "pwd"))
                .perform(webClick())
                .perform(clearElement())
                .perform(webKeys("sampleorg"))
                .perform(webClick())
                .withElement(findElement(Locator.ID, "submit_but"))
                .perform(webClick());
    }
}
