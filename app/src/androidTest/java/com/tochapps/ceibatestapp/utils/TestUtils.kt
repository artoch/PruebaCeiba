package com.tochapps.ceibatestapp.utils

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

val CONNECTION_TIME : Long = 4000
val WAIT_TIME : Long = 2000



fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
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

fun setEditTextInTextView(value: String): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return CoreMatchers.allOf(
                ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(
                    EditText::class.java))
        }

        override fun perform(uiController: UiController, view: View) {
            (view as EditText).setText(value)
        }

        override fun getDescription(): String {
            return "replace text"
        }
    }
}