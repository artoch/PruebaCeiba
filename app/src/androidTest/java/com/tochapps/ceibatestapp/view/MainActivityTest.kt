package com.tochapps.ceibatestapp.view

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions
import com.tochapps.ceibatestapp.R
import com.tochapps.ceibatestapp.common.EMPTY_STRING
import com.tochapps.ceibatestapp.ui.flow.user.list.MainActivity
import com.tochapps.ceibatestapp.utils.CONNECTION_TIME
import com.tochapps.ceibatestapp.utils.WAIT_TIME
import com.tochapps.ceibatestapp.utils.setEditTextInTextView
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)

    @get:Rule
    val rule = ActivityScenarioRule<MainActivity>(intent)

    @Test
    fun checkIfMainActivityHaveData(){

        Thread.sleep(CONNECTION_TIME)
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.recyclerViewSearchResults,
            10
        )

        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.name),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.recyclerViewSearchResults), 0))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.withText("Leanne Graham")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.editTextSearch)).perform(setEditTextInTextView("nne"))

        Thread.sleep(WAIT_TIME)

        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.name),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.recyclerViewSearchResults), 0))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.withText("Leanne Graham")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.name),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.recyclerViewSearchResults), 0))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.withText("Leanne Graham")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.editTextSearch)).perform(setEditTextInTextView(EMPTY_STRING))

        Thread.sleep(WAIT_TIME)

        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.recyclerViewSearchResults,
            10
        )

        Espresso.onView(withId(R.id.editTextSearch)).perform(setEditTextInTextView("Ervin"))

        Thread.sleep(WAIT_TIME)

        Espresso.onView(
            CoreMatchers.allOf(
                withId(R.id.name),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.recyclerViewSearchResults), 0))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.withText("Ervin Howell")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))



    }

    private fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("position $childPosition of parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                if (view.parent !is ViewGroup) return false
                val parent = view.parent as ViewGroup

                return (parentMatcher.matches(parent)
                        && parent.childCount > childPosition
                        && parent.getChildAt(childPosition) == view)
            }
        }
    }

}